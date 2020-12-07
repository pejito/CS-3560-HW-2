import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.List;

public class UserWindow {

    private String windowID;
    private ListView<String> timeline = new ListView<String>();
    private Label updateTime = new Label();
    private AdminPanel panel = AdminPanel.getInstance();

    public UserWindow(String newID){
        this.windowID = newID;
        panel.newUserWindow(this);
    }


    public String getUserWindow() {
        return windowID;
    }

    public ListView<String> getTimeline(){
        return timeline;
    }

    public void generateUserWindow(User user){
        Stage userWindow = new Stage();
        userWindow.setTitle(user.getID());
        userWindow.setMinWidth(500);
        userWindow.setMaxHeight(750);
        TextField userToFollow = new TextField();
        TextField tweetTextField = new TextField();
        ListView<String> followingList = new ListView<String>();
        followingList.getItems().add("User is following: ");
        List<String> following = user.getFollowing();
        for(String userID : following){
            followingList.getItems().add(userID);
        }
        this.getTimeline().getItems().add("Newsfeed");
        List<String> newsFeed = user.getNewsFeed();
        for(String tweet : newsFeed){
            this.getTimeline().getItems().add(tweet);
        }
        Button followButton = new Button("Follow");
        EventHandler<ActionEvent> followAction = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e){
                String followUserID = userToFollow.getText();
                if(followUserID.length() > 0){
                    user.followUser(panel.getUser(followUserID));
                    followingList.getItems().add(followUserID);
                }
            }
        };
        followButton.setOnAction(followAction);


        Button tweetButton = new Button("Tweet");
        EventHandler<ActionEvent> tweetAction = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e){
                String tweet = tweetTextField.getText();
                if(tweet.length() > 0){
                    tweet = user.getID() + " tweets: " + tweet;
                    user.makeAndPostTweet(tweet);
                    panel.newTweet(tweet);
                    timeline.getItems().add(1, tweet);
                    List<String> followers = user.getFollowers();
                    user.setUpdateTime(System.currentTimeMillis());
                    updateTime.setText("User last updated at: " + user.getUpdateTime() + " ms");
                    for(String ID : followers){
                        panel.getUserWindow(ID).timeline.getItems().add(1, tweet);
                        panel.getUserWindow(ID).updateTime.setText("Last updated: " + Long.toString(System.currentTimeMillis()) + " ms");
                    }
                }
            }
        };
        tweetButton.setOnAction(tweetAction);

        Label creationTime = new Label();
        creationTime.setText("Time of user's creation: " + Long.toString(user.getCreationTime()) + " ms");

        HBox windowLayout = new HBox(20);
        BackgroundFill userWindowBGFill = new BackgroundFill(Color.BLUEVIOLET,null,null);
        Background userWindowBG = new Background(userWindowBGFill);
        windowLayout.setBackground(userWindowBG);
        VBox followUser = new VBox(20, userToFollow, followButton, creationTime, updateTime);
        followUser.setAlignment(Pos.CENTER);
        HBox followingLST = new HBox(followingList);
        HBox timelineLV = new HBox(timeline);
        VBox tweet = new VBox(20, tweetTextField, tweetButton);
        tweet.setAlignment(Pos.CENTER);
        windowLayout.getChildren().addAll(followUser, followingLST, timelineLV, tweet);
        Scene sc = new Scene(windowLayout);
        userWindow.setScene(sc);
        userWindow.show();
    }

}
