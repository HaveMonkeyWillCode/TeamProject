/*******************************************************************
*   BrowseState.java
*   CS321 Group Project: Cafe Kiosk
*   Team: Alpha
*       Angela Allison
*       Adam McFry
*       Mitchell Whitehead
*       Bernard Sabatini
*   Date: Oct 2018
*******************************************************************/
package StateMachine;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 * A specific implementation of State to browse a list of items
 * @author Bernard
 */
public class BrowseState implements State{

    @Override
    public Node getGUI(FSM machine) {
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(5));
        
        ObservableList<String> products = FXCollections.observableArrayList();
        products.add("Item 1");
        products.add("Item 2");
        products.add("Item 3");
        
        ListView menuList = new ListView(products);
        
        HBox buttonBar = new HBox();
        buttonBar.setPadding(new Insets(5));
        buttonBar.setSpacing(5);
        
        Button btn_ViewCart = new Button("View Cart");
        btn_ViewCart.setOnAction((event) -> {
            machine.pushState(new CartViewState());
        });
        buttonBar.getChildren().add(btn_ViewCart);
        
        Button btn_Back = new Button("Back to Start");
        btn_Back.setOnAction((event) -> {
            machine.popState();
        });
        buttonBar.getChildren().add(btn_Back);
        
        pane.setLeft(menuList);
        pane.setBottom(buttonBar);
        
        return pane;
    }
    
        
    @Override
    public String toString(){
        return "Browse State";
    }
}
