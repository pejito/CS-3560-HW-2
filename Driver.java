import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import jdk.nashorn.api.tree.Tree;

public class Driver extends Application {
    Stage adminWindow;
    Button newUser;
    Button newGroup;
    Button userWindow;
    Button totalUser;
    Button groupTotal;
    Button tweetTotal;
    Button percPositive;
    Button userGroupVeri;
    Button lastUpdated;
    TreeView<String> treeVW;
    String chosenUser;
    AdminPanel adminPanel = AdminPanel.getInstance();
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            adminWindow = primaryStage;
            adminWindow.setTitle("CS 3560 A2");
            adminPanel.getInstance();
            TextField newGroupTXT = new TextField();
            TextField newUserTXT = new TextField();
            newUser = new Button("New User");
            newUser.setOnAction(new EventHandler<ActionEvent>(){
                public void handle(ActionEvent e){
                String newUser = newUserTXT.getText();
                if(newUser.length() > 0){
                    adminPanel.newUser(newUser, treeVW.getSelectionModel().getSelectedItem());
                    }
                }
            });
            newGroup = new Button("New Group");
            newGroup.setOnAction(new EventHandler<ActionEvent>(){
                public void handle(ActionEvent e){
                    String newGroup = newGroupTXT.getText();
                    if(newGroup.length() > 0){
                        adminPanel.newUserGroup(newGroup, treeVW.getSelectionModel().getSelectedItem());
                    }
                }
            });
            userWindow = new Button("User's Window");
            userWindow.setOnAction(new EventHandler<ActionEvent>(){
                public void handle(ActionEvent e){
                    UserWindow userWindow = new UserWindow(chosenUser);
                    userWindow.generateUserWindow(adminPanel.getUser(chosenUser));
                }
            });
            totalUser = new Button("Total Users");
            totalUser.setOnAction(new EventHandler<ActionEvent>(){
                public void handle(ActionEvent e){
                    Statistics.generateNumUsersStats("Total Users", adminPanel.countUsers());
                }
            });
            groupTotal = new Button("Total Groups");
            groupTotal.setOnAction(new EventHandler<ActionEvent>(){
                public void handle(ActionEvent e){
                    Statistics.generateNumGroupStats("Num Groups", adminPanel.countGroups());
                }
            });
            tweetTotal = new Button("Total Tweets");
            tweetTotal.setOnAction(new EventHandler<ActionEvent>(){
                public void handle(ActionEvent e){
                    Statistics.generateTotalTweetsStats("Total Tweets", adminPanel.countTweets());
                }
            });
            percPositive = new Button("Percent Positive");
            percPositive.setOnAction(new EventHandler<ActionEvent>(){
                public void handle(ActionEvent e){
                    Statistics.generatePositiveTweetsStats("Positive Tweets", adminPanel.countPositive());
                }
            });

            userGroupVeri = new Button("User/Group Verification");
            userGroupVeri.setOnAction(new EventHandler<ActionEvent>(){
                public void handle(ActionEvent e){
                    Statistics.verifyNames(" ", adminPanel.verifyUsersAndGroups());
                }
            });

            lastUpdated = new Button("Find last updated user");
            lastUpdated.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e){
                    Statistics.lastUpdated(" ", adminPanel.getLastUpdatedUser());
                }
            });
            TreeItem<String> hidden = new TreeItem<>("root");
            hidden.setExpanded(false);
            TreeItem<String> root = adminPanel.newUserGroup("Everyone", hidden);
            adminPanel.newUser("Neil", root);
            adminPanel.newUser("Raven", root);
            adminPanel.newUser("Bichael", root);
            adminPanel.newUser("King", root);
            adminPanel.newUser("Paul", root);
            adminPanel.newUser("Mari", root);
            TreeItem<String> bkdDiscord = adminPanel.newUserGroup("Barkada Discord", root);
            adminPanel.newUser("Joyce", bkdDiscord);
            adminPanel.newUser("James",bkdDiscord);
            adminPanel.newUser("Brennan", bkdDiscord);
            TreeItem<String> theRegulars = adminPanel.newUser("The Regular Boys", bkdDiscord);
            adminPanel.newUser("Rigby", theRegulars);
            adminPanel.newUser("Mordecai", theRegulars);
            treeVW = new TreeView<>(root);
            treeVW.setShowRoot(true);
            treeVW.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                if(newValue != null){
                    chosenUser = newValue.getValue();
                }
            });
            HBox windowLayout = new HBox(20);
            BackgroundFill userWindowBGFill = new BackgroundFill(Color.BLUEVIOLET,null,null);
            Background userWindowBG = new Background(userWindowBGFill);
            windowLayout.setBackground(userWindowBG);
            VBox tree = new VBox(20, treeVW);
            VBox statsButtons = new VBox(20);
            statsButtons.setSpacing(40);
            HBox newUserBox = new HBox(20, newUserTXT, newUser);
            HBox newGroupBox = new HBox(20, newGroupTXT, newGroup);
            HBox openUsersWindow = new HBox(userWindow);
            HBox userGroupStats = new HBox(20, totalUser, groupTotal, userGroupVeri);
            HBox tweetStats = new HBox(20, tweetTotal, percPositive, lastUpdated);
            statsButtons.getChildren().addAll(newUserBox, newGroupBox, openUsersWindow, userGroupStats, tweetStats);
            windowLayout.getChildren().addAll(treeVW, statsButtons);
            Scene scene = new Scene(windowLayout, 800, 400);
            adminWindow.setScene(scene);
            adminWindow.show();
        } catch(Exception e){
            System.out.println("broked");
        }
    }
}
