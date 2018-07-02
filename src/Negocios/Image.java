package Negocios;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class Image {

private java.awt.Image image;

    public Image(java.awt.Image image) {
        this.image = image;
    }


    
    
    public DataFlavor[] getTransferDataFlavors(){
        return new DataFlavor[] {DataFlavor.imageFlavor};
    }
    
    public boolean isDataFlavorSupported(DataFlavor flavor){
        return DataFlavor.imageFlavor.equals(flavor);
    }
    
    public Object getTransferData(DataFlavor flavor)throws UnsupportedFlavorException, IOException{
        if (!DataFlavor.imageFlavor.equals(flavor)) {
            throw new UnsupportedFlavorException(flavor);
        }
        return image;
    }    
    
    
}
