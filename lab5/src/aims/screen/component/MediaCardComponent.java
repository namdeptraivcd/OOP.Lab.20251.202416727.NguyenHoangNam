package aims.screen.component;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import aims.media.Media;
import aims.media.playable;

public class MediaCardComponent extends VBox {
    
    private Media media;
    private Runnable onAddToCart;
    private Runnable onPlay;
    private Runnable onShowDetails;
    
    public MediaCardComponent(Media media) {
        this.media = media;
        initializeUI();
    }
    
    private void initializeUI() {
        this.setSpacing(10);
        this.setPrefWidth(250);
        this.setStyle(
            "-fx-border-color: #cccccc; " +
            "-fx-border-width: 1; " +
            "-fx-padding: 15; " +
            "-fx-background-color: white; " +
            "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 10, 0, 0, 2);"
        );
        this.setAlignment(Pos.CENTER);
        
        Label titleLabel = new Label(media.getTitle());
        titleLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 16px;");
        titleLabel.setWrapText(true);
        titleLabel.setMaxWidth(220);
        
        Label categoryLabel = new Label(media.getCategory());
        categoryLabel.setStyle("-fx-text-fill: #666; -fx-font-size: 12px;");
        
        Label costLabel = new Label(String.format("$%.2f", media.getCost()));
        costLabel.setStyle("-fx-text-fill: #d32f2f; -fx-font-weight: bold; -fx-font-size: 14px;");
        
        HBox buttonBox = createButtonBox();
        
        setupMouseEvents();
        
        this.getChildren().addAll(titleLabel, categoryLabel, costLabel, buttonBox);
    }
    
    public static VBox createCard(Media media, Runnable onAddToCart, Runnable onPlay, Runnable onShowDetails) {
        MediaCardComponent card = new MediaCardComponent(media);
        card.setOnAddToCart(onAddToCart);
        card.setOnPlay(onPlay);
        card.setOnShowDetails(onShowDetails);
        return card;
    }
    
    private HBox createButtonBox() {
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        
        Button addButton = new Button("Add to cart");
        addButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
        addButton.setOnAction(e -> {
            if (onAddToCart != null) onAddToCart.run();
        });
        buttonBox.getChildren().add(addButton);
        
        if (media instanceof playable) {
            Button playButton = new Button("Play");
            playButton.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white;");
            playButton.setOnAction(e -> {
                if (onPlay != null) onPlay.run();
            });
            buttonBox.getChildren().add(playButton);
        }
        
        return buttonBox;
    }
    
    private void setupMouseEvents() {
        this.setOnMouseEntered(e -> 
            this.setStyle(this.getStyle() + "-fx-background-color: #f5f5f5;")
        );
        this.setOnMouseExited(e -> 
            this.setStyle(this.getStyle().replace("#f5f5f5", "white"))
        );
        this.setOnMouseClicked(e -> {
            if (onShowDetails != null) onShowDetails.run();
        });
        this.setStyle(this.getStyle() + "-fx-cursor: hand;");
    }
    
    public void setOnAddToCart(Runnable action) {
        this.onAddToCart = action;
    }
    
    public void setOnPlay(Runnable action) {
        this.onPlay = action;
    }
    
    public void setOnShowDetails(Runnable action) {
        this.onShowDetails = action;
    }
    
    public Media getMedia() {
        return media;
    }
}
