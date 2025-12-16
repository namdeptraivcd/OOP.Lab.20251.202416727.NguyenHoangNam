package aims.screen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import aims.media.*;
import aims.store.Cart;
import aims.store.Store;
import aims.screen.component.MediaCardComponent;
import aims.screen.component.DialogHelper;
import aims.screen.handler.MediaHandler;
import java.util.ArrayList;
import java.util.Optional;

public class StoreScreenController {
    @FXML private MenuBar menuBar;
    @FXML private GridPane mediaGrid;
    @FXML private VBox centerContainer;
    @FXML private Label statusLabel;
    
    private Store store;
    private Cart cart;
    private MediaHandler mediaHandler;
    private DialogHelper dialogHelper;
    
    public StoreScreenController() {
    }
    
    public void setStoreAndCart(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
        this.mediaHandler = new MediaHandler(store, cart);
        this.dialogHelper = new DialogHelper();
        populateMediaGrid();
        updateStatus("Store loaded with " + store.getItemsInStore().size() + " items");
    }
    
    @FXML
    public void initialize() {
    }
    
    private void populateMediaGrid() {
        mediaGrid.getChildren().clear();
        ArrayList<Media> items = store.getItemsInStore();
        int column = 0, row = 0;
        
        for (Media media : items) {
            VBox card = MediaCardComponent.createCard(
                media,
                () -> handleAddToCart(media),
                () -> handlePlayMedia(media),
                () -> showMediaDetails(media)
            );
            mediaGrid.add(card, column, row);
            if (++column == 3) {
                column = 0;
                row++;
            }
        }
    }
    
    private void handleAddToCart(Media media) {
        mediaHandler.addToCart(media);
        updateStatus("Added: " + media.getTitle() + " | Cart: " + cart.getItemsOrdered().size() + " items");
    }
    
    @FXML
    private void handleUpdateStore(ActionEvent event) {
        showRemoveMediaDialog();
    }
    
    private void showRemoveMediaDialog() {
        Stage removeStage = new Stage();
        removeStage.setTitle("Remove Media from Store");
        
        VBox dialogBox = new VBox(15);
        dialogBox.setPadding(new Insets(20));
        dialogBox.setStyle("-fx-background-color: white;");
        
        Label titleLabel = new Label("Enter media title to remove:");
        titleLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");
        
        TextField titleInput = new TextField();
        titleInput.setPromptText("Enter exact title...");
        titleInput.setPrefWidth(300);
        
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        
        Button removeBtn = new Button("Remove");
        removeBtn.setStyle(
            "-fx-background-color: #f44336; " +
            "-fx-text-fill: white; " +
            "-fx-padding: 10 20; " +
            "-fx-font-size: 14px;"
        );
        removeBtn.setOnAction(e -> {
            String title = titleInput.getText().trim();
            if (title.isEmpty()) {
                DialogHelper.showError("Error", "Please enter a title!");
                return;
            }
            handleRemoveFromStoreByTitle(title);
            removeStage.close();
        });
        
        Button cancelBtn = new Button("Cancel");
        cancelBtn.setStyle("-fx-padding: 10 20; -fx-font-size: 14px;");
        cancelBtn.setOnAction(e -> removeStage.close());
        
        buttonBox.getChildren().addAll(removeBtn, cancelBtn);
        dialogBox.getChildren().addAll(titleLabel, titleInput, buttonBox);
        
        Scene scene = new Scene(dialogBox, 400, 150);
        removeStage.setScene(scene);
        removeStage.show();
    }
    
    private void handleRemoveFromStoreByTitle(String title) {
        // Find media by title
        Media foundMedia = null;
        for (Media media : store.getItemsInStore()) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                foundMedia = media;
                break;
            }
        }
        
        if (foundMedia == null) {
            DialogHelper.showError("Not Found", "No media found with title: \"" + title + "\"");
            return;
        }
        
        boolean confirm = DialogHelper.showConfirmation(
            "Remove Media", 
            "Are you sure you want to remove \"" + foundMedia.getTitle() + "\" from the store?"
        );
        
        if (confirm) {
            store.removeMedia(foundMedia);
            populateMediaGrid();
            updateStatus("Removed: " + foundMedia.getTitle() + " from store");
            DialogHelper.showInfo("Success", foundMedia.getTitle() + " has been removed from store!");
        }
    }

    private void handlePlayMedia(Media media) {
        mediaHandler.playMedia(media);
        updateStatus("Playing: " + media.getTitle());
    }
    
    @FXML
    private void handleViewStore(ActionEvent event) {
        populateMediaGrid();
        updateStatus("Refreshed store view");
    }
    
    @FXML
    private void handleViewCart(ActionEvent event) {
        showCartDialog();
    }
    
    @FXML
    private void handleAddBook(ActionEvent event) {
        showAddMediaDialog("Book");
    }
    
    @FXML
    private void handleAddCD(ActionEvent event) {
        showAddMediaDialog("CD");
    }
    
    @FXML
    private void handleAddDVD(ActionEvent event) {
        showAddMediaDialog("DVD");
    }
    private void showMediaDetails(Media media) {
        Stage detailStage = new Stage();
        detailStage.setTitle("Media Details");
        VBox detailBox = new VBox(15);
        detailBox.setPadding(new Insets(25));
        detailBox.setAlignment(Pos.TOP_LEFT);
        detailBox.setStyle("-fx-background-color: white;");
        Label titleHeader = new Label(media.getTitle());
        titleHeader.setStyle(
            "-fx-font-size: 24px; " +
            "-fx-font-weight: bold; " +
            "-fx-text-fill: #1976D2;"
        );
        Separator separator1 = new Separator();
        GridPane detailGrid = new GridPane();
        detailGrid.setHgap(15);
        detailGrid.setVgap(12);
        int row = 0;
        detailGrid.add(createDetailLabel("ID:", true), 0, row);
        detailGrid.add(createDetailLabel(String.valueOf(media.getId()), false), 1, row++);
        detailGrid.add(createDetailLabel("Category:", true), 0, row);
        detailGrid.add(createDetailLabel(media.getCategory(), false), 1, row++);
        detailGrid.add(createDetailLabel("Cost:", true), 0, row);
        Label costLabel = createDetailLabel(String.format("$%.2f", media.getCost()), false);
        costLabel.setStyle(costLabel.getStyle() + "-fx-text-fill: #d32f2f; -fx-font-weight: bold;");
        detailGrid.add(costLabel, 1, row++);
        if (media instanceof DVD) {
            DVD dvd = (DVD) media;
            detailGrid.add(createDetailLabel("Type:", true), 0, row);
            detailGrid.add(createDetailLabel("DVD", false), 1, row++);
            detailGrid.add(createDetailLabel("Director:", true), 0, row);
            detailGrid.add(createDetailLabel(dvd.getDirector(), false), 1, row++);
            detailGrid.add(createDetailLabel("Length:", true), 0, row);
            detailGrid.add(createDetailLabel(dvd.getLength() + " minutes", false), 1, row++);
        } else if (media instanceof CompactDisc) {
            CompactDisc cd = (CompactDisc) media;
            detailGrid.add(createDetailLabel("Type:", true), 0, row);
            detailGrid.add(createDetailLabel("Compact Disc", false), 1, row++);
            detailGrid.add(createDetailLabel("Artist:", true), 0, row);
            detailGrid.add(createDetailLabel(cd.getArtist(), false), 1, row++);
            detailGrid.add(createDetailLabel("Length:", true), 0, row);
            detailGrid.add(createDetailLabel(cd.getLength() + " minutes", false), 1, row++);
            if (!cd.getTracks().isEmpty()) {
                detailGrid.add(createDetailLabel("Tracks:", true), 0, row);
                VBox tracksBox = new VBox(5);
                for (int i = 0; i < cd.getTracks().size(); i++) {
                    Track track = cd.getTracks().get(i);
                    Label trackLabel = new Label(
                        String.format("%d. %s (%.1f min)", 
                        i + 1, track.getTitle(), track.getLength())
                    );
                    trackLabel.setStyle("-fx-font-size: 12px;");
                    tracksBox.getChildren().add(trackLabel);
                }
                detailGrid.add(tracksBox, 1, row++);
            }
        } else if (media instanceof Book) {
            Book book = (Book) media;
            detailGrid.add(createDetailLabel("Type:", true), 0, row);
            detailGrid.add(createDetailLabel("Book", false), 1, row++);
            if (!book.getAuthors().isEmpty()) {
                detailGrid.add(createDetailLabel("Authors:", true), 0, row);
                VBox authorsBox = new VBox(3);
                for (String author : book.getAuthors()) {
                    Label authorLabel = new Label("• " + author);
                    authorLabel.setStyle("-fx-font-size: 12px;");
                    authorsBox.getChildren().add(authorLabel);
                }
                detailGrid.add(authorsBox, 1, row++);
            }
        }
        Separator separator2 = new Separator();
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        Button addToCartBtn = new Button("Add to Cart");
        addToCartBtn.setStyle(
            "-fx-background-color: #4CAF50; " +
            "-fx-text-fill: white; " +
            "-fx-padding: 10 20; " +
            "-fx-font-size: 14px;"
        );
        addToCartBtn.setOnAction(e -> {
            handleAddToCart(media);
            detailStage.close();
        });
        buttonBox.getChildren().add(addToCartBtn);
        if (media instanceof playable) {
            Button playBtn = new Button("Play");
            playBtn.setStyle(
                "-fx-background-color: #2196F3; " +
                "-fx-text-fill: white; " +
                "-fx-padding: 10 20; " +
                "-fx-font-size: 14px;"
            );
            playBtn.setOnAction(e -> {
                handlePlayMedia(media);
            });
            buttonBox.getChildren().add(playBtn);
        }
        Button closeBtn = new Button("Close");
        closeBtn.setStyle("-fx-padding: 10 20; -fx-font-size: 14px;");
        closeBtn.setOnAction(e -> detailStage.close());
        buttonBox.getChildren().add(closeBtn);
        detailBox.getChildren().addAll(
            titleHeader, 
            separator1, 
            detailGrid, 
            separator2, 
            buttonBox
        );
        ScrollPane scrollPane = new ScrollPane(detailBox);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background-color: white;");
        Scene scene = new Scene(scrollPane, 500, 600);
        detailStage.setScene(scene);
        detailStage.show();
    }
    private Label createDetailLabel(String text, boolean isBold) {
        Label label = new Label(text);
        if (isBold) {
            label.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");
        } else {
            label.setStyle("-fx-font-size: 14px;");
        }
        return label;
    }
    private void showCartDialog() {
        Stage cartStage = new Stage();
        cartStage.setTitle("Shopping Cart");
        VBox cartBox = new VBox(15);
        cartBox.setPadding(new Insets(20));
        cartBox.setAlignment(Pos.TOP_CENTER);
        Label header = new Label("SHOPPING CART");
        header.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        
        HBox sortBox = new HBox(10);
        sortBox.setAlignment(Pos.CENTER);
        sortBox.setPadding(new Insets(10, 0, 10, 0));
        
        Label sortLabel = new Label("Sort by:");
        sortLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");
        
        Button sortByTitleBtn = new Button("Title → Cost");
        sortByTitleBtn.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white;");
        sortByTitleBtn.setOnAction(e -> {
            cart.sortByTitleCost();
            cartStage.close();
            showCartDialog();
        });
        
        Button sortByCostBtn = new Button("Cost → Title");
        sortByCostBtn.setStyle("-fx-background-color: #FF9800; -fx-text-fill: white;");
        sortByCostBtn.setOnAction(e -> {
            cart.sortByCostTitle();
            cartStage.close();
            showCartDialog();
        });
        
        sortBox.getChildren().addAll(sortLabel, sortByTitleBtn, sortByCostBtn);
        
        ScrollPane scrollPane = new ScrollPane();
        VBox itemsList = new VBox(8);
        itemsList.setPadding(new Insets(10));
        ArrayList<Media> items = cart.getItemsOrdered();
        if (items.isEmpty()) {
            Label emptyLabel = new Label("Cart is empty");
            emptyLabel.setStyle("-fx-text-fill: #999; -fx-font-style: italic;");
            itemsList.getChildren().add(emptyLabel);
        } else {
            for (int i = 0; i < items.size(); i++) {
                Media media = items.get(i);
                HBox itemBox = new HBox(10);
                itemBox.setAlignment(Pos.CENTER_LEFT);
                Label itemLabel = new Label((i+1) + ". " + media.getTitle() + 
                                           " - $" + String.format("%.2f", media.getCost()));
                itemLabel.setStyle("-fx-font-size: 14px;");
                Button removeBtn = new Button("Remove");
                removeBtn.setStyle("-fx-background-color: #f44336; -fx-text-fill: white;");
                removeBtn.setOnAction(e -> {
                    cart.removeMedia(media);
                    showCartDialog(); 
                    cartStage.close();
                });
                itemBox.getChildren().addAll(itemLabel, removeBtn);
                itemsList.getChildren().add(itemBox);
            }
        }
        scrollPane.setContent(itemsList);
        scrollPane.setPrefHeight(300);
        scrollPane.setFitToWidth(true);
        Label totalLabel = new Label(String.format("Total: $%.2f", cart.totalCost()));
        totalLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #d32f2f;");
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        Button placeOrderButton = new Button("Place Order");
        placeOrderButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 14px;");
        placeOrderButton.setDisable(items.isEmpty());
        placeOrderButton.setOnAction(e -> {
            showAlert(Alert.AlertType.INFORMATION, "Order Placed", 
                     "Thank you for your order!\nTotal: $" + String.format("%.2f", cart.totalCost()));
            cart.clear();
            cartStage.close();
            populateMediaGrid();
            updateStatus("Order placed successfully");
        });
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> cartStage.close());
        buttonBox.getChildren().addAll(placeOrderButton, closeButton);
        cartBox.getChildren().addAll(header, sortBox, scrollPane, totalLabel, buttonBox);
        Scene scene = new Scene(cartBox, 500, 500);
        cartStage.setScene(scene);
        cartStage.show();
    }
    private void showAddMediaDialog(String mediaType) {
        if (mediaType.equals("CD")) {
            showAddCDDialog();
            return;
        }
        
        Dialog<Media> dialog = new Dialog<>();
        dialog.setTitle("Add " + mediaType);
        dialog.setHeaderText("Enter " + mediaType + " details:");
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));
        
        // Common fields
        TextField titleField = new TextField();
        titleField.setPromptText("Title");
        TextField categoryField = new TextField();
        categoryField.setPromptText("Category");
        TextField costField = new TextField();
        costField.setPromptText("Cost");
        
        grid.add(new Label("Title:"), 0, 0);
        grid.add(titleField, 1, 0);
        grid.add(new Label("Category:"), 0, 1);
        grid.add(categoryField, 1, 1);
        grid.add(new Label("Cost:"), 0, 2);
        grid.add(costField, 1, 2);
        
        // Specific fields based on media type
        TextField specificField = new TextField();
        TextField lengthField = new TextField();
        
        int currentRow = 3;
        
        if (mediaType.equals("Book")) {
            specificField.setPromptText("Author");
            grid.add(new Label("Author:"), 0, currentRow);
            grid.add(specificField, 1, currentRow);
            
        } else if (mediaType.equals("DVD")) {
            specificField.setPromptText("Director");
            lengthField.setPromptText("Length (minutes)");
            
            grid.add(new Label("Director:"), 0, currentRow);
            grid.add(specificField, 1, currentRow++);
            
            grid.add(new Label("Length:"), 0, currentRow);
            grid.add(lengthField, 1, currentRow);
        }
        
        dialog.getDialogPane().setContent(grid);
        ButtonType addButtonType = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(addButtonType, ButtonType.CANCEL);
        
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == addButtonType) {
                try {
                    String title = titleField.getText();
                    String category = categoryField.getText();
                    float cost = Float.parseFloat(costField.getText());
                    String specific = specificField.getText();
                    
                    Media media = null;
                    
                    switch (mediaType) {
                        case "Book":
                            media = new Book(title, category, cost);
                            break;
                            
                        case "DVD":
                            float dvdLength = Float.parseFloat(lengthField.getText());
                            media = new DVD(title, category, specific, dvdLength, cost);
                            break;
                    }
                    
                    return media;
                    
                } catch (NumberFormatException e) {
                    showAlert(Alert.AlertType.ERROR, "Invalid Input", 
                             "Cost and Length must be valid numbers!");
                    return null;
                }
            }
            return null;
        });
        
        Optional<Media> result = dialog.showAndWait();
        result.ifPresent(media -> {
            store.addMedia(media);
            populateMediaGrid();
            updateStatus("Added: " + media.getTitle() + " to store");
            showAlert(Alert.AlertType.INFORMATION, "Success", 
                     media.getTitle() + " added to store!");
        });
    }
    
    
    
    private void showAddCDDialog() {
        Stage cdStage = new Stage();
        cdStage.setTitle("Add Compact Disc");
        
        VBox mainBox = new VBox(10);
        mainBox.setPadding(new Insets(15));
        
        GridPane cdInfoGrid = new GridPane();
        cdInfoGrid.setHgap(10);
        cdInfoGrid.setVgap(8);
        
        Label headerLabel = new Label("CD Information");
        
        TextField titleField = new TextField();
        TextField categoryField = new TextField();
        TextField artistField = new TextField();
        TextField costField = new TextField();
        
        cdInfoGrid.add(new Label("Title:"), 0, 0);
        cdInfoGrid.add(titleField, 1, 0);
        cdInfoGrid.add(new Label("Category:"), 0, 1);
        cdInfoGrid.add(categoryField, 1, 1);
        cdInfoGrid.add(new Label("Artist:"), 0, 2);
        cdInfoGrid.add(artistField, 1, 2);
        cdInfoGrid.add(new Label("Cost:"), 0, 3);
        cdInfoGrid.add(costField, 1, 3);
        
        Label tracksLabel = new Label("Tracks");
        
        TextField numTracksField = new TextField();
        numTracksField.setPrefWidth(100);
        
        Button generateTracksBtn = new Button("Generate");
        
        HBox numTracksBox = new HBox(10);
        numTracksBox.getChildren().addAll(new Label("Number of tracks:"), numTracksField, generateTracksBtn);
        
        VBox tracksContainer = new VBox(8);
        ScrollPane tracksScrollPane = new ScrollPane(tracksContainer);
        tracksScrollPane.setPrefHeight(250);
        tracksScrollPane.setFitToWidth(true);
        
        ArrayList<TextField> trackTitleFields = new ArrayList<>();
        ArrayList<TextField> trackLengthFields = new ArrayList<>();
        
        generateTracksBtn.setOnAction(e -> {
            try {
                int numTracks = Integer.parseInt(numTracksField.getText());
                
                tracksContainer.getChildren().clear();
                trackTitleFields.clear();
                trackLengthFields.clear();
                
                for (int i = 0; i < numTracks; i++) {
                    GridPane trackGrid = new GridPane();
                    trackGrid.setHgap(10);
                    trackGrid.setVgap(5);
                    
                    Label trackNumLabel = new Label("Track " + (i + 1));
                    
                    TextField trackTitle = new TextField();
                    trackTitle.setPrefWidth(200);
                    
                    TextField trackLength = new TextField();
                    trackLength.setPrefWidth(100);
                    
                    trackTitleFields.add(trackTitle);
                    trackLengthFields.add(trackLength);
                    
                    trackGrid.add(trackNumLabel, 0, 0);
                    trackGrid.add(new Label("Title:"), 0, 1);
                    trackGrid.add(trackTitle, 1, 1);
                    trackGrid.add(new Label("Length:"), 2, 1);
                    trackGrid.add(trackLength, 3, 1);
                    
                    tracksContainer.getChildren().add(trackGrid);
                }
                
            } catch (NumberFormatException ex) {
                showAlert(Alert.AlertType.ERROR, "Error", "Invalid number!");
            }
        });
        
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        
        Button addButton = new Button("Add CD");
        addButton.setOnAction(e -> {
            try {
                String title = titleField.getText();
                String category = categoryField.getText();
                String artist = artistField.getText();
                float cost = Float.parseFloat(costField.getText());
                
                CompactDisc cd = new CompactDisc(title, category, cost, artist);
                
                for (int i = 0; i < trackTitleFields.size(); i++) {
                    String trackTitle = trackTitleFields.get(i).getText();
                    float trackLength = Float.parseFloat(trackLengthFields.get(i).getText());
                    
                    Track track = new Track(trackTitle, trackLength);
                    cd.addTrack(track);
                }
                
                store.addMedia(cd);
                
                populateMediaGrid();
                updateStatus("Added: " + title + " (" + trackTitleFields.size() + " tracks, " + 
                           String.format("%.1f", cd.getLength()) + " min)");
                
                showAlert(Alert.AlertType.INFORMATION, "Success", 
                         "Added: " + title + "\nTotal length: " + 
                         String.format("%.1f", cd.getLength()) + " minutes");
                
                cdStage.close();
                
            } catch (NumberFormatException ex) {
                showAlert(Alert.AlertType.ERROR, "Error", "Invalid input!");
            } catch (Exception ex) {
                showAlert(Alert.AlertType.ERROR, "Error", ex.getMessage());
            }
        });
        
        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(e -> cdStage.close());
        
        buttonBox.getChildren().addAll(addButton, cancelButton);
        
        mainBox.getChildren().addAll(
            headerLabel,
            cdInfoGrid,
            new Separator(),
            tracksLabel,
            numTracksBox,
            tracksScrollPane,
            buttonBox
        );
        
        Scene scene = new Scene(mainBox, 550, 600);
        cdStage.setScene(scene);
        cdStage.show();
    }
    
    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    private void updateStatus(String message) {
        if (statusLabel != null) {
            statusLabel.setText(message);
        }
    }
}
