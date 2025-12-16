package aims.screen.handler;

import aims.exception.PlayerException;
import aims.exception.LimitExceededException;
import aims.media.CompactDisc;
import aims.media.Media;
import aims.media.playable;
import aims.screen.component.DialogHelper;
import aims.store.Cart;
import aims.store.Store;

public class MediaHandler {
    
    private Store store;
    private Cart cart;
    
    public MediaHandler(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
    }
    
    public void addToCart(Media media) {
        try {
            cart.addMedia(media);
            DialogHelper.showInfo("Success", media.getTitle() + " added to cart!");
        } catch (LimitExceededException e) {
            DialogHelper.showError("Cart Full", e.getMessage());
        } catch (Exception e) {
            DialogHelper.showError("Error", "Failed to add to cart: " + e.getMessage());
        }
    }
    
    public void playMedia(Media media) {
        if (media instanceof playable) {
            try {
                ((playable) media).play();
                
                String successMsg = "Playing: " + media.getTitle();
                if (media instanceof CompactDisc) {
                    CompactDisc cd = (CompactDisc) media;
                    successMsg += "\n\nAll " + cd.getTracks().size() + " tracks played successfully!";
                }
                
                DialogHelper.showInfo("Playing Successfully", successMsg);
                
            } catch (PlayerException e) {
                String errorMsg = e.getMessage();
                
                if (media instanceof CompactDisc) {
                    CompactDisc cd = (CompactDisc) media;
                    String header = "CD: " + cd.getTitle() + "\n" + 
                                  "Artist: " + cd.getArtist() + "\n" +
                                  "Total tracks: " + cd.getTracks().size() + "\n\n";
                    
                    if (errorMsg.contains("track(s) không play được:")) {
                        String trackErrors = errorMsg.substring(errorMsg.indexOf(":") + 1).trim();
                        errorMsg = header + "TRACKS KHONG PLAY DUOC:\n" + trackErrors;
                    } else {
                        errorMsg = header + errorMsg;
                    }
                }
                
                DialogHelper.showError("Playback Error", errorMsg);
            }
        }
    }
    
    public void addMediaToStore(Media media) {
        store.addMedia(media);
    }
    
    public Store getStore() {
        return store;
    }
    
    public Cart getCart() {
        return cart;
    }
}
