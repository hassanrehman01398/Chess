/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import java.util.ArrayList;
import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Hamza
 */
public class Chess extends Application {

    int row = 7, column = 0/*black castle postion*/, row1 = 7, column1 = 1/*black castle horse1*/, row2 = 7, column2 = 6/*black castle horse2*/;//blackimages default row and column
    int blackbishoprow = 7, blackbishopcolumn = 2, blackqueenrow = 7, blackqueencolumn = 3, blackcastle1column = 7, blackcastlerow = 7, blackbishoprow1 = 7, blackbishopcolumn1 = 5;
    int rowwhitepiece = 1, columnwhitepiece = 0, rowwhitepiece1 = 1, columnwhitepiece1 = 1, rowwhitepiece2 = 1, columnwhitepiece2 = 2, rowwhitecastle = 0, columnwhitecastle = 0, rowwhitepiece3 = 1, columnwhitepiece3 = 3, rowwhitepiece4 = 1, columnwhitepiece4 = 4, rowwhitepiece5 = 1, columnwhitepiece5 = 5, rowwhitepiece6 = 1, columnwhitepiece6 = 6, rowwhitepiece7 = 1, columnwhitepiece7 = 7;
    int rowblackpiece = 6, columnblackpiece = 0, rowblackpiece1 = 6, columnblackpiece1 = 1, rowblackpiece2 = 6, columnblackpiece2 = 2, rowblackpiece3 = 6, columnblackpiece3 = 3, rowblackpiece4 = 6, columnblackpiece4 = 4, rowblackpiece5 = 6, columnblackpiece5 = 5, rowblackpiece6 = 6, columnblackpiece6 = 6, rowblackpiece7 = 6, columnblackpiece7 = 7;
    int rowwhitecastle1 = 0, columnwhitecastle1 = 7, rowwhitehorse = 0, columnwhitehorse = 1, rowwhitehorse1 = 0, columnwhitehorse1 = 6, rowwhitebishop = 0, columnwhitebishop = 2, rowwhitebishop1 = 0, columnwhitebishop1 = 5, rowwhitequeen = 0, columnwhitequeen = 3;
    ImageView imblackqueen;
    String opposite = "black";
    ArrayList<ImageView> whiteimages = new ArrayList<>();
    ArrayList<ImageView> blackimages = new ArrayList<>();
    ArrayList<ImageView> whitehorses = new ArrayList<>();
    ArrayList<ImageView> whitepawns = new ArrayList<>();
    ArrayList<ImageView> whitecastles = new ArrayList<>();
    ArrayList<ImageView> whitebishops = new ArrayList<>();
    ArrayList<ImageView> blackhorses = new ArrayList<>();
    ArrayList<ImageView> blackpawns = new ArrayList<>();
    ArrayList<ImageView> blackcastles = new ArrayList<>();
    ArrayList<ImageView> blackbishops = new ArrayList<>();
    ArrayList<Integer> whitecolumn = new ArrayList<>();
    ArrayList<Integer> whiterow = new ArrayList<>();
    ArrayList<Integer> blackcolumn = new ArrayList<>();
    ArrayList<Integer> blackrow = new ArrayList<>();

    Alert a = new Alert(Alert.AlertType.ERROR);

    int valid = 0;
    int blackkingrow = 7, blackkingcolumn = 4;
    int whitekingrow = 0, whitekingcolumn = 4;
    int count = 0;
    int checkup = 0, checkup1 = 0;
    int checkdown = 0, checkdown1 = 0;
    int kill = 0;
    String name = "";
    Rectangle[][] r = new Rectangle[8][8];
    Rectangle[][] ra = new Rectangle[8][8];
    Image check = new Image("Images/check.gif");
    ImageView imcheck = new ImageView(check);
    ImageView imwhitequeen;
//InnerShadow is=new InnerShadow(5,0f , 0f, Color.RED);
    Text t = new Text();
    GridPane root = new GridPane();
    ImageView imwhiteking;
    ImageView imblackking;

    @Override
    public void start(Stage primaryStage) {

        // GridPane root1=new GridPane();
        a.setTitle("Checked");
        a.setHeaderText("Checked");
        a.setContentText("You got Checked");
        a.setX(100);
        a.setY(200);
        a.setWidth(200);
        a.setHeight(300);
        a.setGraphic(imcheck);
        a.setResizable(false);
        imcheck.setFitHeight(30);
        imcheck.setFitWidth(60);
        Image blackbishop = new Image("Images/blackbishop.png");
        ImageView imblackbishop = new ImageView(blackbishop);
        imblackbishop.setFitWidth(50);
        imblackbishop.setFitHeight(50);
        Image blackking = new Image("Images/king.png");
        imblackking = new ImageView(blackking);
        imblackking.setFitWidth(50);
        imblackking.setFitHeight(50);
        Image whiteking = new Image("Images/whiteking.png");
        imwhiteking = new ImageView(whiteking);
        imwhiteking.setFitWidth(50);
        imwhiteking.setFitHeight(50);

        //Image blackbishop=new Image("Images/blackbishop.png");
        Image blackpiece = new Image("Images/frontpiece.png");
//      is.setBlurType(BlurType.GAUSSIAN);
//      is.setWidth(60);
//      is.setHeight(60);
        ImageView imblackpiece = new ImageView(blackpiece);
        imblackpiece.setFitWidth(70);
        imblackpiece.setFitHeight(70);
        ImageView imblackpiece1 = new ImageView(blackpiece);
        imblackpiece1.setFitWidth(70);
        imblackpiece1.setFitHeight(70);
        ImageView imblackpiece2 = new ImageView(blackpiece);
        imblackpiece2.setFitWidth(70);
        imblackpiece2.setFitHeight(70);
        ImageView imblackpiece3 = new ImageView(blackpiece);
        imblackpiece3.setFitWidth(70);
        imblackpiece3.setFitHeight(70);
        ImageView imblackpiece4 = new ImageView(blackpiece);
        imblackpiece4.setFitWidth(70);
        imblackpiece4.setFitHeight(70);
        ImageView imblackpiece5 = new ImageView(blackpiece);
        imblackpiece5.setFitWidth(70);
        imblackpiece5.setFitHeight(70);
        ImageView imblackpiece6 = new ImageView(blackpiece);
        imblackpiece6.setFitWidth(70);
        imblackpiece6.setFitHeight(70);
        ImageView imblackpiece7 = new ImageView(blackpiece);
        imblackpiece7.setFitWidth(70);
        imblackpiece7.setFitHeight(70);
        Image imwhitehorse = new Image("Images/whitehorse.png");
        Image imwhitebishop = new Image("Images/whiteknight.png");

        ImageView imgwhitehorse = new ImageView(imwhitehorse);
        imgwhitehorse.setFitWidth(40);
        imgwhitehorse.setFitHeight(50);
        ImageView imgwhitehorse1 = new ImageView(imwhitehorse);
        imgwhitehorse1.setFitWidth(40);
        imgwhitehorse1.setFitHeight(50);
        ImageView imgwhitebishop = new ImageView(imwhitebishop);
        imgwhitebishop.setFitWidth(60);
        imgwhitebishop.setFitHeight(50);
        ImageView imgwhitebishop1 = new ImageView(imwhitebishop);
        imgwhitebishop1.setFitWidth(60);
        imgwhitebishop1.setFitHeight(50);

        ImageView imblackbishop1 = new ImageView(blackbishop);
        imblackbishop1.setFitWidth(50);
        imblackbishop1.setFitHeight(50);
        Image blackqueen = new Image("Images/queen.png");
        imblackqueen = new ImageView(blackqueen);
        imblackqueen.setFitWidth(60);
        imblackqueen.setFitHeight(65);
        Image whitequeen = new Image("Images/whitequeen.png");
        imwhitequeen = new ImageView(whitequeen);
        imwhitequeen.setFitWidth(60);
        imwhitequeen.setFitHeight(65);

        Image imcastle = new Image("Images/castle.png");
        ImageView img = new ImageView(imcastle);
        img.setFitWidth(50);
        img.setFitHeight(50);
        //Image imcastl1e=new Image("Images/castle.png");
        ImageView img1 = new ImageView(imcastle);
        img1.setFitWidth(50);
        img1.setFitHeight(50);

        Image imhorse = new Image("Images/horse.png");
        ImageView imghorseblack = new ImageView(imhorse);
        imghorseblack.setFitWidth(70);
        imghorseblack.setFitHeight(70);
        ImageView imghorseblack1 = new ImageView(imhorse);
        imghorseblack1.setFitWidth(70);
        imghorseblack1.setFitHeight(70);
        Image imwhitecastle = new Image("Images/whitecastle.png");
        ImageView imgwhitecastle = new ImageView(imwhitecastle);
        imgwhitecastle.setFitWidth(35);
        imgwhitecastle.setFitHeight(40);
        ImageView imgwhitecastle1 = new ImageView(imwhitecastle);
        imgwhitecastle1.setFitWidth(35);
        imgwhitecastle1.setFitHeight(40);

        Image imwhite = new Image("Images/white piece.png");
        ImageView imgwhite = new ImageView(imwhite);
        imgwhite.setFitWidth(35);
        imgwhite.setFitHeight(30);
        ImageView imgwhite1 = new ImageView(imwhite);
        imgwhite1.setFitWidth(35);
        imgwhite1.setFitHeight(30);
        ImageView imgwhite2 = new ImageView(imwhite);
        imgwhite2.setFitWidth(35);
        imgwhite2.setFitHeight(30);
        ImageView imgwhite3 = new ImageView(imwhite);
        imgwhite3.setFitWidth(35);
        imgwhite3.setFitHeight(30);
        ImageView imgwhite4 = new ImageView(imwhite);
        imgwhite4.setFitWidth(35);
        imgwhite4.setFitHeight(30);
        ImageView imgwhite5 = new ImageView(imwhite);
        imgwhite5.setFitWidth(35);
        imgwhite5.setFitHeight(30);
        ImageView imgwhite6 = new ImageView(imwhite);
        imgwhite6.setFitWidth(35);
        imgwhite6.setFitHeight(30);
        ImageView imgwhite7 = new ImageView(imwhite);
        imgwhite7.setFitWidth(35);
        imgwhite7.setFitHeight(30);
        blackhorses.add(imghorseblack);
        blackhorses.add(imghorseblack1);
        whitehorses.add(imgwhitehorse);
        whitehorses.add(imgwhitehorse1);
//whiteimages arraylist additon
        whiteimages.add(imgwhite);
//0
        whitecolumn.add(columnwhitepiece);
        whiterow.add(rowwhitepiece);
        whiteimages.add(imgwhite1);//1
        whitecolumn.add(columnwhitepiece1);
        whiterow.add(rowwhitepiece1);
        whiteimages.add(imgwhite2);//2
        whitecolumn.add(columnwhitepiece2);
        whiterow.add(rowwhitepiece2);
        whiteimages.add(imgwhite3);//4
        whitecolumn.add(columnwhitepiece3);
        whiterow.add(rowwhitepiece3);
        whiteimages.add(imgwhite4);//5
        whitecolumn.add(columnwhitepiece4);
        whiterow.add(rowwhitepiece4);
        whiteimages.add(imgwhite5);//6
        whitecolumn.add(columnwhitepiece5);
        whiterow.add(rowwhitepiece5);
        whiteimages.add(imgwhite6);//7
        whitecolumn.add(columnwhitepiece6);
        whiterow.add(rowwhitepiece6);
        whiteimages.add(imgwhite7);//8
        whitecolumn.add(columnwhitepiece7);
        whiterow.add(rowwhitepiece7);
        whiteimages.add(imgwhitecastle);//3
        whitecolumn.add(columnwhitecastle);
        whiterow.add(rowwhitecastle);
        whiteimages.add(imgwhitecastle1);//9
        whitecolumn.add(columnwhitecastle1);
        whiterow.add(rowwhitecastle1);
        whiteimages.add(imgwhitehorse);//10
        whitecolumn.add(columnwhitehorse);
        whiterow.add(rowwhitehorse);
        whiteimages.add(imgwhitehorse1);//11
        whitecolumn.add(columnwhitehorse1);
        whiterow.add(rowwhitehorse1);
        whiteimages.add(imgwhitebishop);//12
        whitecolumn.add(columnwhitebishop);
        whiterow.add(rowwhitebishop);
        whiteimages.add(imgwhitebishop1);//13
        whitecolumn.add(columnwhitebishop1);
        whiterow.add(rowwhitebishop1);
        whiteimages.add(imwhitequeen);//14
        whitecolumn.add(columnwhitequeen);
        whiterow.add(rowwhitequeen);
        whiteimages.add(imwhiteking);//15

        //////////
        whitecastles.add(imgwhitecastle);
        whitecastles.add(imgwhitecastle1);

        blackcastles.add(img);
        blackcastles.add(img1);
        /////////blackimages addition of array list
        blackimages.add(img);
        blackcolumn.add(column);
        blackrow.add(row);
        blackimages.add(img1);
        blackcolumn.add(blackcastle1column);
        blackrow.add(blackcastlerow);
        blackimages.add(imblackqueen);
        blackcolumn.add(blackqueencolumn);
        blackrow.add(blackqueenrow);
        blackimages.add(imghorseblack);
        blackcolumn.add(column1);
        blackrow.add(row1);
        blackimages.add(imghorseblack1);
        blackcolumn.add(column2);
        blackrow.add(row2);
        blackimages.add(imblackbishop);
        blackcolumn.add(blackbishopcolumn);
        blackrow.add(blackbishoprow);
        blackimages.add(imblackbishop1);
        blackcolumn.add(blackbishopcolumn1);
        blackrow.add(blackbishoprow1);
        blackimages.add(imblackpiece);
        blackcolumn.add(columnblackpiece);
        blackrow.add(rowblackpiece);
        blackimages.add(imblackpiece1);
        blackcolumn.add(columnblackpiece1);
        blackrow.add(rowblackpiece1);
        blackimages.add(imblackpiece2);
        blackcolumn.add(columnblackpiece2);
        blackrow.add(rowblackpiece2);
        blackimages.add(imblackpiece3);
        blackcolumn.add(columnblackpiece3);
        blackrow.add(rowblackpiece3);
        blackimages.add(imblackpiece4);
        blackcolumn.add(columnblackpiece4);
        blackrow.add(rowblackpiece4);
        blackimages.add(imblackpiece5);
        blackcolumn.add(columnblackpiece5);
        blackrow.add(rowblackpiece5);
        blackimages.add(imblackpiece6);
        blackcolumn.add(columnblackpiece6);
        blackrow.add(rowblackpiece6);
        blackimages.add(imblackpiece7);
        blackcolumn.add(columnblackpiece7);
        blackrow.add(rowblackpiece7);
        blackimages.add(imblackking);
        //////////
        whitepawns.add(imgwhite);
        whitepawns.add(imgwhite1);
        whitepawns.add(imgwhite2);
        whitepawns.add(imgwhite3);
        whitepawns.add(imgwhite4);
        whitepawns.add(imgwhite5);
        whitepawns.add(imgwhite6);
        whitepawns.add(imgwhite7);
        whitebishops.add(imgwhitebishop);
        whitebishops.add(imgwhitebishop1);
        blackpawns.add(imblackpiece);
        blackpawns.add(imblackpiece1);
        blackpawns.add(imblackpiece2);
        blackpawns.add(imblackpiece3);
        blackpawns.add(imblackpiece4);
        blackpawns.add(imblackpiece5);
        blackpawns.add(imblackpiece6);
        blackpawns.add(imblackpiece7);
        blackbishops.add(imblackbishop);
        blackbishops.add(imblackbishop1);
        for (int i = 0; i < whiteimages.size(); i++) {
            System.out.println(whiteimages.get(i));
            System.out.println(whiteimages.size());
        }
        int y = 0;
        for (int i = 0; i < r.length; i++) {
            for (int j = 0; j < r[i].length; j++) {
                r[i][j] = new Rectangle(70, 70);
                if (y % 2 == 0) {
                    r[i][j].setFill(Color.CHOCOLATE);

                } else {
                    r[i][j].setFill(Color.WHITE);

                }
                root.add(r[i][j], j, i);
                // ra.add(r[i][j]);
                ra[i][j] = r[i][j];
//          r[i][j].setX(j+5);
//          r[i][j].setY(i+5);

                y++;

            }
            if (y % 2 == 0) {
                y = 1;
            } else {
                y = 0;
            }
        }

        InnerShadow borderGlow = new InnerShadow();
        borderGlow.setOffsetY(0f);
        borderGlow.setOffsetX(0f);
        borderGlow.setColor(Color.BLUE);
        borderGlow.setWidth(40);
        borderGlow.setHeight(40);
//white
        root.add(imgwhite2, 2, 1);
        root.add(img, 0, 7);
        root.add(imgwhite, 0, 1);
        root.add(imgwhite1, 1, 1);
        root.add(imgwhite3, 3, 1);
        root.add(imgwhite4, 4, 1);
        root.add(imgwhite5, 5, 1);
        root.add(imgwhite6, 6, 1);
        root.add(imgwhite7, 7, 1);
        root.add(imwhiteking, 4, 0);
        root.add(imgwhitehorse, 1, 0);
        root.add(imgwhitehorse1, 6, 0);
//root.add(imgwhitecastle,0,0);
        root.add(imgwhitecastle1, 7, 0);
        root.add(imgwhitebishop, 2, 0);
        root.add(imwhitequeen, 3, 0);
        root.add(imgwhitebishop1, 5, 0);

        root.add(imgwhitecastle, 0, 0);
        root.add(img1, 7, 7);

//black
        root.add(imghorseblack, 1, 7);
        root.add(imghorseblack1, 6, 7);
        root.add(imblackbishop, 2, 7);
        root.add(imblackqueen, 3, 7);
        root.add(imblackbishop1, 5, 7);
        root.add(t, 0, 4);
        root.add(imblackpiece, 0, 6);
        root.add(imblackpiece1, 1, 6);
        root.add(imblackpiece2, 2, 6);
        root.add(imblackpiece3, 3, 6);
        root.add(imblackpiece4, 4, 6);
        root.add(imblackpiece5, 5, 6);
        root.add(imblackpiece6, 6, 6);
        root.add(imblackpiece7, 7, 6);
        root.add(imblackking, 4, 7);
//   System.out.println(whitecolumn.get(3));
//              System.out.println(whiterow.get(3));
//if(opposite.equals("white"))
//{
//    System.out.println(opposite);
        imgwhitecastle.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (imgwhitecastle.isPressed()) {
                    if (opposite.equals("white")) {
                        name = "whitecastle";
                        clear();
                        checkup = 0;
                        checkdown = 0;
                        checkup1 = 0;
                        checkdown1 = 0;

                        for (int i = 0; i < r.length; i++) {
                            for (int j = 0; j < r[i].length; j++) {
                                if (i == rowwhitecastle) {
                                    int hup = root.getColumnIndex(imgwhitecastle);
                                    int hdown = root.getColumnIndex(imgwhitecastle);

                                    for (int k = 1; k < r[i].length; k++) {
                                        //    for (int t = 0; t < blackimages.size(); t++) {
                                        if ((hup - k) >= 0 || hdown + k <= 7) {
                                            //    System.out.println("ahmad");
                                            for (int q = 0; q < blackimages.size(); q++) {
                                                //      System.out.println("faraz");
                                                if (checkup == 0 && (GridPane.getRowIndex(blackimages.get(q)) == rowwhitecastle && GridPane.getColumnIndex(blackimages.get(q)) == hup - k) || (GridPane.getRowIndex(whiteimages.get(q)) == rowwhitecastle && GridPane.getColumnIndex(whiteimages.get(q)) == hup - k) && hup - k >= 0 && checkup == 0) // if(GridPane.getColumnIndex(whiteimages.get(q))==column&&GridPane.getRowIndex(whiteimages.get(q))==hup-k&&hup-k>=0&&checkup==0&&GridPane.getColumnIndex(blackimages.get(q))!=GridPane.getColumnIndex(blackimages)//&&blackimages.get(q)!=img) 
                                                {
                                                    //        System.out.println("talha");
                                                    if (GridPane.getColumnIndex(blackimages.get(q)) == hup - k && GridPane.getRowIndex(blackimages.get(q)) == rowwhitecastle) {
                                                        //          System.out.println("fazool");
                                                        borderGlow.setColor(Color.RED);
                                                        r[rowwhitecastle][hup - k].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }
                                                    checkup++;
                                                }
                                            }
                                            if (checkup == 0 && hup - k >= 0) {
                                                //System.out.println("huziafa");
                                                r[rowwhitecastle][hup - k].setEffect(borderGlow);

                                            }

                                            for (int l = 0; l < blackimages.size(); l++) {

                                                //System.out.println("owais");
                                                if (checkdown == 0 && (GridPane.getRowIndex(blackimages.get(l)) == rowwhitecastle && GridPane.getColumnIndex(blackimages.get(l)) == hdown + k) || (GridPane.getRowIndex(whiteimages.get(l)) == rowwhitecastle && GridPane.getColumnIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7) {
                                                    // System.out.println("sufiyan");
                                                    if (GridPane.getColumnIndex(blackimages.get(l)) == hdown + k && GridPane.getRowIndex(blackimages.get(l)) == rowwhitecastle) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[rowwhitecastle][hdown + k].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    } else {
                                                    }
                                                    checkdown++;
                                                }

                                            }
                                            if (checkdown == 0 && hdown + k <= 7) {
                                                // System.out.println("fizan");
                                                r[rowwhitecastle][hdown + k].setEffect(borderGlow);

                                            }
                                        }//checking condition

                                    }
                                }
                                int hup = root.getRowIndex(imgwhitecastle);
                                int hdown = root.getRowIndex(imgwhitecastle);
                                //hup= to check up rows
                                //hdown=to check down rows
                                if (j == columnwhitecastle) {
                                    checkup1 = 0;
                                    checkdown1 = 0;

                                    for (int k = 1; k < r.length; k++) {
                                        if ((hup - k) >= 0 || hdown + k <= 7) {
                                            for (int q = 0; q < blackimages.size(); q++) {
                                                if (checkup1 == 0 && (GridPane.getColumnIndex(blackimages.get(q)) == columnwhitecastle && GridPane.getRowIndex(blackimages.get(q)) == hup - k) || (GridPane.getColumnIndex(whiteimages.get(q)) == columnwhitecastle && GridPane.getRowIndex(whiteimages.get(q)) == hup - k) && hup - k >= 0 && checkup1 == 0) {
                                                    if (GridPane.getRowIndex(blackimages.get(q)) == hup - k && GridPane.getColumnIndex(blackimages.get(q)) == columnwhitecastle) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[hup - k][columnwhitecastle].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }
                                                    checkup1++;
                                                }
                                            }
                                            if (checkup1 == 0 && hup - k >= 0) {
                                                //System.out.println("huziafa");
                                                r[hup - k][columnwhitecastle].setEffect(borderGlow);

                                            }

                                            for (int l = 0; l < blackimages.size(); l++) {

                                                if (checkdown1 == 0 && (GridPane.getColumnIndex(blackimages.get(l)) == columnwhitecastle && GridPane.getRowIndex(blackimages.get(l)) == hdown + k) || (GridPane.getColumnIndex(whiteimages.get(l)) == columnwhitecastle && GridPane.getRowIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7) {
                                                    if (GridPane.getRowIndex(blackimages.get(l)) == hdown + k && GridPane.getColumnIndex(blackimages.get(l)) == columnwhitecastle) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[hdown + k][columnwhitecastle].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }

                                                    checkdown1++;
                                                }

                                            }
                                            if (checkdown1 == 0 && hdown + k <= 7) {
                                                r[hdown + k][columnwhitecastle].setEffect(borderGlow);

                                            }
                                        }//checking condition

                                        if (checkup1 != 0 && checkdown1 != 0 && checkup != 0 && checkdown != 0) {
                                            break;
                                        }
                                    }

                                }

                            }

                        }
                    }
                }
            }
        });

        imgwhite.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (imgwhite.isPressed()) {
                    if (opposite.equals("white")) {
                        name = "whitepawn1";
                        clear();
                        for (int i = 0; i < r.length; i++) {

                            for (int j = 0; j < r[i].length; j++) {
                                int hdown = root.getRowIndex(imgwhite);
                                if (j == columnwhitepiece) {
                                    checkup = 0;
                                    checkdown = 0;
                                    int p;
                                    if (hdown == 1) {
                                        p = 2;
                                    } else {
                                        p = 1;
                                    }
                                    for (int k = 1; k <= p; k++) {
                                        // System.out.println("hassan");
                                        if (hdown + k <= 7) {
                                            //    System.out.println("ahmad");
                                            for (int q = 0; q < blackimages.size(); q++) {
                                                //      System.out.println("faraz");
                                                if ((GridPane.getColumnIndex(blackimages.get(q)) == columnwhitepiece - 1 && GridPane.getRowIndex(blackimages.get(q)) == hdown + k) || (GridPane.getColumnIndex(whiteimages.get(q)) == columnwhitepiece - 1 && GridPane.getRowIndex(whiteimages.get(q)) == hdown + k) && hdown + k <= 7 && k == 1 && checkup == 0) // if(GridPane.getColumnIndex(whiteimages.get(q))==column&&GridPane.getRowIndex(whiteimages.get(q))==hup-k&&hup-k>=0&&checkup==0&&GridPane.getColumnIndex(blackimages.get(q))!=GridPane.getColumnIndex(blackimages)//&&blackimages.get(q)!=img) 
                                                {
                                                    //        System.out.println("talha");
                                                    if (GridPane.getRowIndex(blackimages.get(q)) == hdown + k && GridPane.getColumnIndex(blackimages.get(q)) == columnwhitepiece - 1) {
                                                        //          System.out.println("fazool");
                                                        borderGlow.setColor(Color.RED);
                                                        r[hdown + k][columnwhitepiece - 1].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }
                                                    checkup++;
                                                }
                                            }
//                                   
                                            for (int l = 0; l < blackimages.size(); l++) {

                                                if (checkdown == 0 && k == 1 && (GridPane.getColumnIndex(blackimages.get(l)) == columnwhitepiece + 1 && GridPane.getRowIndex(blackimages.get(l)) == hdown + k) || (GridPane.getColumnIndex(whiteimages.get(l)) == columnwhitepiece + 1 && GridPane.getRowIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7) {
                                                    if (GridPane.getRowIndex(blackimages.get(l)) == hdown + k && GridPane.getColumnIndex(blackimages.get(l)) == columnwhitepiece + 1) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[hdown + k][columnwhitepiece + 1].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    } else {
                                                    }
                                                    checkdown++;
                                                }

                                                for (int m = 0; m < blackimages.size(); m++) {

                                                    if ((GridPane.getColumnIndex(blackimages.get(m)) == columnwhitepiece && GridPane.getRowIndex(blackimages.get(m)) == hdown + k) || (GridPane.getColumnIndex(whiteimages.get(m)) == columnblackpiece && GridPane.getRowIndex(whiteimages.get(m)) == hdown + k) && hdown + k <= 7) {
                                                        checkup1++;
                                                    }
                                                }
                                                if (checkup1 == 0 && hdown + k <= 7) {
                                                    // System.out.println("fizan");
                                                    r[hdown + k][columnwhitepiece].setEffect(borderGlow);

                                                }
                                            }//checking condition

                                        }

                                    }

                                }

                            }
                        }
                    }
                }
            }
        });
        imgwhitecastle1.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (imgwhitecastle1.isPressed()) {
                    if (opposite.equals("white")) {
                        name = "whitecastle1";
                        clear();

                        for (int i = 0; i < r.length; i++) {
                            for (int j = 0; j < r[i].length; j++) {
                                if (i == rowwhitecastle1) {
                                    checkup = 0;
                                    checkdown = 0;
                                    checkup1 = 0;
                                    checkdown1 = 0;

                                    int hup = root.getColumnIndex(imgwhitecastle1);
                                    int hdown = root.getColumnIndex(imgwhitecastle1);

                                    for (int k = 1; k < r[i].length; k++) {
                                        //    for (int t = 0; t < blackimages.size(); t++) {
                                        if ((hup - k) >= 0 || hdown + k <= 7) {
                                            //    System.out.println("ahmad");
                                            for (int q = 0; q < blackimages.size(); q++) {
                                                //      System.out.println("faraz");
                                                if (checkup == 0 && (GridPane.getRowIndex(blackimages.get(q)) == rowwhitecastle1 && GridPane.getColumnIndex(blackimages.get(q)) == hup - k) || (GridPane.getRowIndex(whiteimages.get(q)) == rowwhitecastle1 && GridPane.getColumnIndex(whiteimages.get(q)) == hup - k) && hup - k >= 0) // if(GridPane.getColumnIndex(whiteimages.get(q))==column&&GridPane.getRowIndex(whiteimages.get(q))==hup-k&&hup-k>=0&&checkup==0&&GridPane.getColumnIndex(blackimages.get(q))!=GridPane.getColumnIndex(blackimages)//&&blackimages.get(q)!=img) 
                                                {
                                                    //        System.out.println("talha");
                                                    if (GridPane.getColumnIndex(blackimages.get(q)) == hup - k && GridPane.getRowIndex(blackimages.get(q)) == rowwhitecastle1) {
                                                        //          System.out.println("fazool");
                                                        borderGlow.setColor(Color.RED);
                                                        r[rowwhitecastle1][hup - k].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }
                                                    checkup++;
                                                }
                                            }
                                            if (checkup == 0 && hup - k >= 0) {
                                                //System.out.println("huziafa");
                                                r[rowwhitecastle1][hup - k].setEffect(borderGlow);

                                            }

                                            for (int l = 0; l < blackimages.size(); l++) {

                                                //System.out.println("owais");
                                                if (checkdown == 0 && (GridPane.getRowIndex(blackimages.get(l)) == rowwhitecastle1 && GridPane.getColumnIndex(blackimages.get(l)) == hdown + k) || (GridPane.getRowIndex(whiteimages.get(l)) == rowwhitecastle1 && GridPane.getColumnIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7) {
                                                    // System.out.println("sufiyan");
                                                    if (GridPane.getColumnIndex(blackimages.get(l)) == hdown + k && GridPane.getRowIndex(blackimages.get(l)) == rowwhitecastle1) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[rowwhitecastle1][hdown + k].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }
                                                    checkdown++;
                                                }

                                            }
                                            if (checkdown == 0 && hdown + k <= 7) {
                                                // System.out.println("fizan");
                                                r[rowwhitecastle1][hdown + k].setEffect(borderGlow);

                                            }
                                        }//checking condition

                                    }
                                }
                                int hup = root.getRowIndex(imgwhitecastle1);
                                int hdown = root.getRowIndex(imgwhitecastle1);
                                //hup= to check up rows
                                //hdown=to check down rows
                                if (j == columnwhitecastle1) {
                                    checkup1 = 0;
                                    checkdown1 = 0;

                                    for (int k = 1; k < r.length; k++) {
                                        if ((hup - k) >= 0 || hdown + k <= 7) {
                                            for (int q = 0; q < blackimages.size(); q++) {
                                                if (checkup1 == 0 && (GridPane.getColumnIndex(blackimages.get(q)) == columnwhitecastle1 && GridPane.getRowIndex(blackimages.get(q)) == hup - k) || (GridPane.getColumnIndex(whiteimages.get(q)) == columnwhitecastle1 && GridPane.getRowIndex(whiteimages.get(q)) == hup - k) && hup - k >= 0) {
                                                    if (GridPane.getRowIndex(blackimages.get(q)) == hup - k && GridPane.getColumnIndex(blackimages.get(q)) == columnwhitecastle1) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[hup - k][columnwhitecastle1].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }
                                                    checkup1++;
                                                }
                                            }
                                            if (checkup1 == 0 && hup - k >= 0) {
                                                //System.out.println("huziafa");
                                                r[hup - k][columnwhitecastle1].setEffect(borderGlow);

                                            }

                                            for (int l = 0; l < blackimages.size(); l++) {

                                                if (checkdown1 == 0 && (GridPane.getColumnIndex(blackimages.get(l)) == columnwhitecastle1 && GridPane.getRowIndex(blackimages.get(l)) == hdown + k) || (GridPane.getColumnIndex(whiteimages.get(l)) == columnwhitecastle1 && GridPane.getRowIndex(whiteimages.get(l)) == hdown + k) && whiteimages.get(l) != img && hdown + k <= 7) {
                                                    if (GridPane.getRowIndex(blackimages.get(l)) == hdown + k && GridPane.getColumnIndex(blackimages.get(l)) == columnwhitecastle1) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[hdown + k][columnwhitecastle1].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }
                                                    checkdown1++;
                                                }

                                            }
                                            if (checkdown1 == 0 && hdown + k <= 7) {
                                                r[hdown + k][columnwhitecastle1].setEffect(borderGlow);

                                            }
                                        }//checking condition

                                        if (checkup != 0 && checkdown != 0 && checkup1 != 0 && checkdown1 != 0) {
                                            break;
                                        }

                                    }

                                }

                            }
                        }
                    }
                }
            }
        });

        imgwhite1.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (imgwhite1.isPressed()) {
                    if (opposite.equals("white")) {
                        name = "whitepawn2";
                        clear();
                        for (int i = 0; i < r.length; i++) {

                            for (int j = 0; j < r[i].length; j++) {
                                int hdown = root.getRowIndex(imgwhite1);
                                if (j == columnwhitepiece1) {
                                    checkup = 0;
                                    checkup1 = 0;
                                    checkdown = 0;
                                    int p;
                                    if (hdown == 1) {
                                        p = 2;
                                    } else {
                                        p = 1;
                                    }
                                    for (int k = 1; k <= p; k++) {
                                        // System.out.println("hassan");
                                        if (hdown + k <= 7) {
                                            //    System.out.println("ahmad");
                                            for (int q = 0; q < blackimages.size(); q++) {
                                                //      System.out.println("faraz");
                                                if (k == 1 && (GridPane.getColumnIndex(blackimages.get(q)) == columnwhitepiece1 - 1 && GridPane.getRowIndex(blackimages.get(q)) == hdown + k) || (GridPane.getColumnIndex(whiteimages.get(q)) == columnwhitepiece1 - 1 && GridPane.getRowIndex(whiteimages.get(q)) == hdown + k) && hdown + k <= 7 && checkup == 0) // if(GridPane.getColumnIndex(whiteimages.get(q))==column&&GridPane.getRowIndex(whiteimages.get(q))==hup-k&&hup-k>=0&&checkup==0&&GridPane.getColumnIndex(blackimages.get(q))!=GridPane.getColumnIndex(blackimages)//&&blackimages.get(q)!=img) 
                                                {
                                                    //        System.out.println("talha");
                                                    if (GridPane.getRowIndex(blackimages.get(q)) == hdown + k && GridPane.getColumnIndex(blackimages.get(q)) == columnwhitepiece1 - 1) {
                                                        //          System.out.println("fazool");
                                                        borderGlow.setColor(Color.RED);
                                                        r[hdown + k][columnwhitepiece1 - 1].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }
                                                    checkup++;
                                                }
                                            }
//                                   if(checkup==0&&hup-k>=0)
//                                   {
//                                       //System.out.println("huziafa");
//                                         r[hup-k][column].setEffect(borderGlow);
//                                             
//                                   }
//                                   
                                            for (int l = 0; l < blackimages.size(); l++) {

                                                //System.out.println("owais");
                                                if (k == 1 && checkdown == 0 && (GridPane.getColumnIndex(blackimages.get(l)) == columnwhitepiece1 + 1 && GridPane.getRowIndex(blackimages.get(l)) == hdown + k) || (GridPane.getColumnIndex(whiteimages.get(l)) == columnwhitepiece1 + 1 && GridPane.getRowIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7) {
                                                    // System.out.println("sufiyan");
                                                    if (GridPane.getRowIndex(blackimages.get(l)) == hdown + k && GridPane.getColumnIndex(blackimages.get(l)) == columnwhitepiece1 + 1) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[hdown + k][columnwhitepiece1 + 1].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    } else {
                                                    }
                                                    checkdown++;
                                                }

                                                for (int m = 0; m < blackimages.size(); m++) {

                                                    if ((GridPane.getColumnIndex(blackimages.get(m)) == columnwhitepiece1 && GridPane.getRowIndex(blackimages.get(m)) == hdown + k) || (GridPane.getColumnIndex(whiteimages.get(m)) == columnblackpiece1 && GridPane.getRowIndex(whiteimages.get(m)) == hdown + k) && hdown + k <= 7) {
                                                        checkup1++;
                                                    }
                                                }
                                                if (checkup1 == 0 && hdown + k <= 7) {
                                                    // System.out.println("fizan");
                                                    r[hdown + k][columnwhitepiece1].setEffect(borderGlow);

                                                }
                                            }//checking condition

                                        }

                                    }

                                }

                            }
                        }
                    }
                }
            }
        });

        imgwhite2.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (imgwhite2.isPressed()) {
                    if (opposite.equals("white")) {
                        name = "whitepawn3";
                        clear();
                        for (int i = 0; i < r.length; i++) {

                            for (int j = 0; j < r[i].length; j++) {
                                int hdown = root.getRowIndex(imgwhite2);
                                if (j == columnwhitepiece2) {
                                    checkup = 0;
                                    checkup1 = 0;
                                    checkdown = 0;
                                    int p;
                                    if (hdown == 1) {
                                        p = 2;
                                    } else {
                                        p = 1;
                                    }
                                    for (int k = 1; k <= p; k++) {
                                        // System.out.println("hassan");
                                        if (hdown + k <= 7) {
                                            //    System.out.println("ahmad");
                                            for (int q = 0; q < blackimages.size(); q++) {
                                                //      System.out.println("faraz");
                                                if (k == 1 && (GridPane.getColumnIndex(blackimages.get(q)) == columnwhitepiece2 - 1 && GridPane.getRowIndex(blackimages.get(q)) == hdown + k) || (GridPane.getColumnIndex(whiteimages.get(q)) == columnwhitepiece2 - 1 && GridPane.getRowIndex(whiteimages.get(q)) == hdown + k) && hdown + k <= 7 && checkup == 0) // if(GridPane.getColumnIndex(whiteimages.get(q))==column&&GridPane.getRowIndex(whiteimages.get(q))==hup-k&&hup-k>=0&&checkup==0&&GridPane.getColumnIndex(blackimages.get(q))!=GridPane.getColumnIndex(blackimages)//&&blackimages.get(q)!=img) 
                                                {
                                                    //        System.out.println("talha");
                                                    if (GridPane.getRowIndex(blackimages.get(q)) == hdown + k && GridPane.getColumnIndex(blackimages.get(q)) == columnwhitepiece2 - 1) {
                                                        //          System.out.println("fazool");
                                                        borderGlow.setColor(Color.RED);
                                                        r[hdown + k][columnwhitepiece2 - 1].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }
                                                    checkup++;
                                                }
                                            }
//                                   if(checkup==0&&hup-k>=0)
//                                   {
//                                       //System.out.println("huziafa");
//                                         r[hup-k][column].setEffect(borderGlow);
//                                             
//                                   }
//                                   
                                            for (int l = 0; l < blackimages.size(); l++) {

                                                //System.out.println("owais");
                                                if (k == 1 && checkdown == 0 && (GridPane.getColumnIndex(blackimages.get(l)) == columnwhitepiece2 + 1 && GridPane.getRowIndex(blackimages.get(l)) == hdown + k) || (GridPane.getColumnIndex(whiteimages.get(l)) == columnwhitepiece2 + 1 && GridPane.getRowIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7) {
                                                    // System.out.println("sufiyan");
                                                    if (GridPane.getRowIndex(blackimages.get(l)) == hdown + k && GridPane.getColumnIndex(blackimages.get(l)) == columnwhitepiece2 + 1) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[hdown + k][columnwhitepiece2 + 1].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    } else {
                                                    }
                                                    checkdown++;
                                                }

                                                for (int m = 0; m < blackimages.size(); m++) {

                                                    if ((GridPane.getColumnIndex(blackimages.get(m)) == columnwhitepiece2 && GridPane.getRowIndex(blackimages.get(m)) == hdown + k) || (GridPane.getColumnIndex(whiteimages.get(m)) == columnblackpiece2 && GridPane.getRowIndex(whiteimages.get(m)) == hdown + k) && hdown + k <= 7) {
                                                        checkup1++;
                                                    }
                                                }
                                                if (checkup1 == 0 && hdown + k <= 7) {
                                                    // System.out.println("fizan");
                                                    r[hdown + k][columnwhitepiece2].setEffect(borderGlow);

                                                }
                                            }//checking condition

                                        }

                                    }

                                }

                            }
                        }
                    }
                }
            }
        });

        imgwhite3.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (imgwhite3.isPressed()) {
                    if (opposite.equals("white")) {
                        name = "whitepawn4";
                        clear();
                        for (int i = 0; i < r.length; i++) {

                            for (int j = 0; j < r[i].length; j++) {
                                int hdown = root.getRowIndex(imgwhite3);
                                if (j == columnwhitepiece3) {
                                    checkup = 0;
                                    checkup1 = 0;
                                    checkdown = 0;
                                    int p;
                                    if (hdown == 1) {
                                        p = 2;
                                    } else {
                                        p = 1;
                                    }
                                    for (int k = 1; k <= p; k++) {
                                        // System.out.println("hassan");
                                        if (hdown + k <= 7) {
                                            //    System.out.println("ahmad");
                                            for (int q = 0; q < blackimages.size(); q++) {
                                                //      System.out.println("faraz");
                                                if (k == 1 && (GridPane.getColumnIndex(blackimages.get(q)) == columnwhitepiece3 - 1 && GridPane.getRowIndex(blackimages.get(q)) == hdown + k) || (GridPane.getColumnIndex(whiteimages.get(q)) == columnwhitepiece3 - 1 && GridPane.getRowIndex(whiteimages.get(q)) == hdown + k) && hdown + k <= 7 && checkup == 0) // if(GridPane.getColumnIndex(whiteimages.get(q))==column&&GridPane.getRowIndex(whiteimages.get(q))==hup-k&&hup-k>=0&&checkup==0&&GridPane.getColumnIndex(blackimages.get(q))!=GridPane.getColumnIndex(blackimages)//&&blackimages.get(q)!=img) 
                                                {
                                                    //        System.out.println("talha");
                                                    if (GridPane.getRowIndex(blackimages.get(q)) == hdown + k && GridPane.getColumnIndex(blackimages.get(q)) == columnwhitepiece3 - 1) {
                                                        //          System.out.println("fazool");
                                                        borderGlow.setColor(Color.RED);
                                                        r[hdown + k][columnwhitepiece3 - 1].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }
                                                    checkup++;
                                                }
                                            }
//                                   
                                            for (int l = 0; l < blackimages.size(); l++) {

                                                if (k == 1 && checkdown == 0 && (GridPane.getColumnIndex(blackimages.get(l)) == columnwhitepiece3 + 1 && GridPane.getRowIndex(blackimages.get(l)) == hdown + k) || (GridPane.getColumnIndex(whiteimages.get(l)) == columnwhitepiece3 + 1 && GridPane.getRowIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7) {
                                                    if (GridPane.getRowIndex(blackimages.get(l)) == hdown + k && GridPane.getColumnIndex(blackimages.get(l)) == columnwhitepiece3 + 1) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[hdown + k][columnwhitepiece3 + 1].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    } else {
                                                    }
                                                    checkdown++;
                                                }

                                                for (int m = 0; m < blackimages.size(); m++) {

                                                    if ((GridPane.getColumnIndex(blackimages.get(m)) == columnwhitepiece3 && GridPane.getRowIndex(blackimages.get(m)) == hdown + k) || (GridPane.getColumnIndex(whiteimages.get(m)) == columnblackpiece3 && GridPane.getRowIndex(whiteimages.get(m)) == hdown + k) && hdown + k <= 7) {
                                                        checkup1++;
                                                    }
                                                }
                                                if (checkup1 == 0 && hdown + k <= 7) {
                                                    // System.out.println("fizan");
                                                    r[hdown + k][columnwhitepiece3].setEffect(borderGlow);

                                                }
                                            }//checking condition

                                        }

                                    }

                                }

                            }
                        }
                    }
                }
            }
        });
        imgwhite4.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (imgwhite4.isPressed()) {
                    if (opposite.equals("white")) {
                        name = "whitepawn5";
                        clear();
                        for (int i = 0; i < r.length; i++) {

                            for (int j = 0; j < r[i].length; j++) {
                                int hdown = root.getRowIndex(imgwhite4);
                                if (j == columnwhitepiece4) {
                                    checkup = 0;
                                    checkup1 = 0;
                                    checkdown = 0;
                                    int p;
                                    if (hdown == 1) {
                                        p = 2;
                                    } else {
                                        p = 1;
                                    }
                                    for (int k = 1; k <= p; k++) {
                                        // System.out.println("hassan");
                                        if (hdown + k <= 7) {
                                            //    System.out.println("ahmad");
                                            for (int q = 0; q < blackimages.size(); q++) {
                                                //      System.out.println("faraz");
                                                if (k == 1 && (GridPane.getColumnIndex(blackimages.get(q)) == columnwhitepiece4 - 1 && GridPane.getRowIndex(blackimages.get(q)) == hdown + k) || (GridPane.getColumnIndex(whiteimages.get(q)) == columnwhitepiece4 - 1 && GridPane.getRowIndex(whiteimages.get(q)) == hdown + k) && hdown + k <= 7 && checkup == 0) // if(GridPane.getColumnIndex(whiteimages.get(q))==column&&GridPane.getRowIndex(whiteimages.get(q))==hup-k&&hup-k>=0&&checkup==0&&GridPane.getColumnIndex(blackimages.get(q))!=GridPane.getColumnIndex(blackimages)//&&blackimages.get(q)!=img) 
                                                {
                                                    //        System.out.println("talha");
                                                    if (GridPane.getRowIndex(blackimages.get(q)) == hdown + k && GridPane.getColumnIndex(blackimages.get(q)) == columnwhitepiece4 - 1) {
                                                        //          System.out.println("fazool");
                                                        borderGlow.setColor(Color.RED);
                                                        r[hdown + k][columnwhitepiece4 - 1].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }
                                                    checkup++;
                                                }
                                            }
//                                   if(checkup==0&&hup-k>=0)
//                                   {
//                                       //System.out.println("huziafa");
//                                         r[hup-k][column].setEffect(borderGlow);
//                                             
//                                   }
//                                   
                                            for (int l = 0; l < blackimages.size(); l++) {

                                                //System.out.println("owais");
                                                if (k == 1 && checkdown == 0 && (GridPane.getColumnIndex(blackimages.get(l)) == columnwhitepiece4 + 1 && GridPane.getRowIndex(blackimages.get(l)) == hdown + k) || (GridPane.getColumnIndex(whiteimages.get(l)) == columnwhitepiece4 + 1 && GridPane.getRowIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7) {
                                                    // System.out.println("sufiyan");
                                                    if (GridPane.getRowIndex(blackimages.get(l)) == hdown + k && GridPane.getColumnIndex(blackimages.get(l)) == columnwhitepiece4 + 1) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[hdown + k][columnwhitepiece4 + 1].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    } else {
                                                    }
                                                    checkdown++;
                                                }

                                                for (int m = 0; m < blackimages.size(); m++) {

                                                    if ((GridPane.getColumnIndex(blackimages.get(m)) == columnwhitepiece4 && GridPane.getRowIndex(blackimages.get(m)) == hdown + k) || (GridPane.getColumnIndex(whiteimages.get(m)) == columnblackpiece4 && GridPane.getRowIndex(whiteimages.get(m)) == hdown + k) && hdown + k <= 7) {
                                                        checkup1++;
                                                    }
                                                }
                                                if (checkup1 == 0 && hdown + k <= 7) {
                                                    // System.out.println("fizan");
                                                    r[hdown + k][columnwhitepiece4].setEffect(borderGlow);

                                                }
                                            }//checking condition

                                        }

                                    }

                                }

                            }
                        }
                    }
                }
            }
        });
        imgwhite5.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (imgwhite5.isPressed()) {
                    if (opposite.equals("white")) {
                        name = "whitepawn6";
                        clear();
                        for (int i = 0; i < r.length; i++) {

                            for (int j = 0; j < r[i].length; j++) {
                                int hdown = root.getRowIndex(imgwhite5);
                                if (j == columnwhitepiece5) {
                                    checkup = 0;
                                    checkdown = 0;
                                    checkup1 = 0;
                                    int p;
                                    if (hdown == 1) {
                                        p = 2;
                                    } else {
                                        p = 1;
                                    }
                                    for (int k = 1; k <= p; k++) {
                                        // System.out.println("hassan");
                                        if (hdown + k <= 7) {
                                            //    System.out.println("ahmad");
                                            for (int q = 0; q < blackimages.size(); q++) {
                                                //      System.out.println("faraz");
                                                if (k == 1 && (GridPane.getColumnIndex(blackimages.get(q)) == columnwhitepiece5 - 1 && GridPane.getRowIndex(blackimages.get(q)) == hdown + k) || (GridPane.getColumnIndex(whiteimages.get(q)) == columnwhitepiece5 - 1 && GridPane.getRowIndex(whiteimages.get(q)) == hdown + k) && hdown + k <= 7 && checkup == 0) // if(GridPane.getColumnIndex(whiteimages.get(q))==column&&GridPane.getRowIndex(whiteimages.get(q))==hup-k&&hup-k>=0&&checkup==0&&GridPane.getColumnIndex(blackimages.get(q))!=GridPane.getColumnIndex(blackimages)//&&blackimages.get(q)!=img) 
                                                {
                                                    //        System.out.println("talha");
                                                    if (GridPane.getRowIndex(blackimages.get(q)) == hdown + k && GridPane.getColumnIndex(blackimages.get(q)) == columnwhitepiece5 - 1) {
                                                        //          System.out.println("fazool");
                                                        borderGlow.setColor(Color.RED);
                                                        r[hdown + k][columnwhitepiece5 - 1].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }
                                                    checkup++;
                                                }
                                            }
//                                   if(checkup==0&&hup-k>=0)
//                                   {
//                                       //System.out.println("huziafa");
//                                         r[hup-k][column].setEffect(borderGlow);
//                                             
//                                   }
//                                   
                                            for (int l = 0; l < blackimages.size(); l++) {

                                                //System.out.println("owais");
                                                if (k == 1 && checkdown == 0 && (GridPane.getColumnIndex(blackimages.get(l)) == columnwhitepiece5 + 1 && GridPane.getRowIndex(blackimages.get(l)) == hdown + k) || (GridPane.getColumnIndex(whiteimages.get(l)) == columnwhitepiece5 + 1 && GridPane.getRowIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7) {
                                                    // System.out.println("sufiyan");
                                                    if (GridPane.getRowIndex(blackimages.get(l)) == hdown + k && GridPane.getColumnIndex(blackimages.get(l)) == columnwhitepiece5 + 1) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[hdown + k][columnwhitepiece5 + 1].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    } else {
                                                    }
                                                    checkdown++;
                                                }

                                                for (int m = 0; m < blackimages.size(); m++) {

                                                    if ((GridPane.getColumnIndex(blackimages.get(m)) == columnwhitepiece5 && GridPane.getRowIndex(blackimages.get(m)) == hdown + k) || (GridPane.getColumnIndex(whiteimages.get(m)) == columnblackpiece5 && GridPane.getRowIndex(whiteimages.get(m)) == hdown + k) && hdown + k <= 7) {
                                                        checkup1++;
                                                    }
                                                }
                                                if (checkup1 == 0 && hdown + k <= 7) {
                                                    // System.out.println("fizan");
                                                    r[hdown + k][columnwhitepiece5].setEffect(borderGlow);

                                                }
                                            }//checking condition

                                        }

                                    }

                                }

                            }
                        }
                    }
                }
            }
        });
        imgwhite6.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (imgwhite6.isPressed()) {
                    if (opposite.equals("white")) {
                        name = "whitepawn7";
                        clear();
                        for (int i = 0; i < r.length; i++) {

                            for (int j = 0; j < r[i].length; j++) {
                                int hdown = root.getRowIndex(imgwhite6);
                                if (j == columnwhitepiece6) {
                                    checkup = 0;
                                    checkdown = 0;
                                    checkup1 = 0;
                                    int p;
                                    if (hdown == 1) {
                                        p = 2;
                                    } else {
                                        p = 1;
                                    }
                                    for (int k = 1; k <= p; k++) {
                                        // System.out.println("hassan");
                                        if (hdown + k <= 7) {
                                            //    System.out.println("ahmad");
                                            for (int q = 0; q < blackimages.size(); q++) {
                                                //      System.out.println("faraz");
                                                if (k == 1 && (GridPane.getColumnIndex(blackimages.get(q)) == columnwhitepiece6 - 1 && GridPane.getRowIndex(blackimages.get(q)) == hdown + k) || (GridPane.getColumnIndex(whiteimages.get(q)) == columnwhitepiece6 - 1 && GridPane.getRowIndex(whiteimages.get(q)) == hdown + k) && hdown + k <= 7 && checkup == 0) // if(GridPane.getColumnIndex(whiteimages.get(q))==column&&GridPane.getRowIndex(whiteimages.get(q))==hup-k&&hup-k>=0&&checkup==0&&GridPane.getColumnIndex(blackimages.get(q))!=GridPane.getColumnIndex(blackimages)//&&blackimages.get(q)!=img) 
                                                {
                                                    //        System.out.println("talha");
                                                    if (GridPane.getRowIndex(blackimages.get(q)) == hdown + k && GridPane.getColumnIndex(blackimages.get(q)) == columnwhitepiece6 - 1) {
                                                        //          System.out.println("fazool");
                                                        borderGlow.setColor(Color.RED);
                                                        r[hdown + k][columnwhitepiece6 - 1].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }
                                                    checkup++;
                                                }
                                            }
//                                   if(checkup==0&&hup-k>=0)
//                                   {
//                                       //System.out.println("huziafa");
//                                         r[hup-k][column].setEffect(borderGlow);
//                                             
//                                   }
//                                   
                                            for (int l = 0; l < blackimages.size(); l++) {

                                                //System.out.println("owais");
                                                if (k == 1 && checkdown == 0 && (GridPane.getColumnIndex(blackimages.get(l)) == columnwhitepiece6 + 1 && GridPane.getRowIndex(blackimages.get(l)) == hdown + k) || (GridPane.getColumnIndex(whiteimages.get(l)) == columnwhitepiece6 + 1 && GridPane.getRowIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7) {
                                                    // System.out.println("sufiyan");
                                                    if (GridPane.getRowIndex(blackimages.get(l)) == hdown + k && GridPane.getColumnIndex(blackimages.get(l)) == columnwhitepiece6 + 1) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[hdown + k][columnwhitepiece6 + 1].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    } else {
                                                    }
                                                    checkdown++;
                                                }

                                                for (int m = 0; m < blackimages.size(); m++) {

                                                    if ((GridPane.getColumnIndex(blackimages.get(m)) == columnwhitepiece6 && GridPane.getRowIndex(blackimages.get(m)) == hdown + k) || (GridPane.getColumnIndex(whiteimages.get(m)) == columnblackpiece6 && GridPane.getRowIndex(whiteimages.get(m)) == hdown + k) && hdown + k <= 7) {
                                                        checkup1++;
                                                    }
                                                }
                                                if (checkup1 == 0 && hdown + k <= 7) {
                                                    // System.out.println("fizan");
                                                    r[hdown + k][columnwhitepiece6].setEffect(borderGlow);

                                                }
                                            }//checking condition

                                        }

                                    }

                                }

                            }
                        }
                    }
                }
            }
        });
        imgwhite7.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (imgwhite7.isPressed()) {
                    name = "whitepawn8";
                    if (opposite.equals("white")) {
                        clear();
                        for (int i = 0; i < r.length; i++) {

                            for (int j = 0; j < r[i].length; j++) {
                                int hdown = root.getRowIndex(imgwhite7);
                                if (j == columnwhitepiece7) {
                                    checkup = 0;
                                    checkup1 = 0;
                                    checkdown = 0;
                                    int p;
                                    if (hdown == 1) {
                                        p = 2;
                                    } else {
                                        p = 1;
                                    }
                                    for (int k = 1; k <= p; k++) {
                                        // System.out.println("hassan");
                                        if (hdown + k <= 7) {
                                            //    System.out.println("ahmad");
                                            for (int q = 0; q < blackimages.size(); q++) {
                                                //      System.out.println("faraz");
                                                if (k == 1 && (GridPane.getColumnIndex(blackimages.get(q)) == columnwhitepiece7 - 1 && GridPane.getRowIndex(blackimages.get(q)) == hdown + k) || (GridPane.getColumnIndex(whiteimages.get(q)) == columnwhitepiece7 - 1 && GridPane.getRowIndex(whiteimages.get(q)) == hdown + k) && hdown + k <= 7 && checkup == 0) // if(GridPane.getColumnIndex(whiteimages.get(q))==column&&GridPane.getRowIndex(whiteimages.get(q))==hup-k&&hup-k>=0&&checkup==0&&GridPane.getColumnIndex(blackimages.get(q))!=GridPane.getColumnIndex(blackimages)//&&blackimages.get(q)!=img) 
                                                {
                                                    //        System.out.println("talha");
                                                    if (GridPane.getRowIndex(blackimages.get(q)) == hdown + k && GridPane.getColumnIndex(blackimages.get(q)) == columnwhitepiece7 - 1) {
                                                        //          System.out.println("fazool");
                                                        borderGlow.setColor(Color.RED);
                                                        r[hdown + k][columnwhitepiece7 - 1].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }
                                                    checkup++;
                                                }
                                            }
//                                   if(checkup==0&&hup-k>=0)
//                                   {
//                                       //System.out.println("huziafa");
//                                         r[hup-k][column].setEffect(borderGlow);
//                                             
//                                   }
//                                   
                                            for (int l = 0; l < blackimages.size(); l++) {

                                                //System.out.println("owais");
                                                if (k == 1 && checkdown == 0 && (GridPane.getColumnIndex(blackimages.get(l)) == columnwhitepiece7 + 1 && GridPane.getRowIndex(blackimages.get(l)) == hdown + k) || (GridPane.getColumnIndex(whiteimages.get(l)) == columnwhitepiece7 + 1 && GridPane.getRowIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7) {
                                                    // System.out.println("sufiyan");
                                                    if (GridPane.getRowIndex(blackimages.get(l)) == hdown + k && GridPane.getColumnIndex(blackimages.get(l)) == columnwhitepiece7 + 1) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[hdown + k][columnwhitepiece7 + 1].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    } else {
                                                    }
                                                    checkdown++;
                                                }

                                                for (int m = 0; m < blackimages.size(); m++) {

                                                    if ((GridPane.getColumnIndex(blackimages.get(m)) == columnwhitepiece7 && GridPane.getRowIndex(blackimages.get(m)) == hdown + k) || (GridPane.getColumnIndex(whiteimages.get(m)) == columnblackpiece7 && GridPane.getRowIndex(whiteimages.get(m)) == hdown + k) && hdown + k <= 7) {
                                                        checkup1++;
                                                    }
                                                }
                                                if (checkup1 == 0 && hdown + k <= 7) {
                                                    // System.out.println("fizan");
                                                    r[hdown + k][columnwhitepiece7].setEffect(borderGlow);

                                                }
                                            }//checking condition

                                        }

                                    }

                                }

                            }
                        }
                    }
                }
            }
        });
        imwhiteking.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (imwhiteking.isPressed()) {
                    if (opposite.equals("white")) {
                        clear();
                        name = "whiteking";
                        checkup = 0;
                        checkdown = 0;
                        checkup1 = 0;
                        checkdown1 = 0;

                        int hup = root.getColumnIndex(imwhiteking);
                        int hdown = root.getColumnIndex(imwhiteking);

                        for (int k = 1; k <= 1; k++) {
                            //    for (int t = 0; t < blackimages.size(); t++) {
                            if ((hup - k) >= 0 || hdown + k <= 7) {
                                //    System.out.println("ahmad");
                                if (checkfirst1(root.getRowIndex(imwhiteking), whitekingrow, whitekingcolumn - 1, -1) == true || (checkblackcastle(root.getRowIndex(imwhiteking), root.getColumnIndex(imwhiteking) - 1) == true) || (checkblackpawn(root.getRowIndex(imwhiteking), root.getColumnIndex(imwhiteking) - 1)) || (checkblackbishops(root.getRowIndex(imwhiteking), root.getColumnIndex(imwhiteking) - 1)) || (checkblackqueen(root.getRowIndex(imwhiteking), root.getColumnIndex(imwhiteking) - 1))) {
                                    System.out.println("CASTLE PEACHA JA RAHA 1");
                                    checkup++;
                                }
                                for (int q = 0; q < blackimages.size(); q++) {
                                    //      System.out.println("faraz");
                                    if (checkup == 0&&(GridPane.getRowIndex(blackimages.get(q)) == whitekingrow && GridPane.getColumnIndex(blackimages.get(q)) == hup - k) || (GridPane.getRowIndex(whiteimages.get(q)) == whitekingrow && GridPane.getColumnIndex(whiteimages.get(q)) == hup - k) && hup - k >= 0 ) {
                                        if (GridPane.getColumnIndex(blackimages.get(q)) == hup - k && GridPane.getRowIndex(blackimages.get(q)) == whitekingrow) {
   System.out.println("CASTLE PEACHA JA RAHA 3");                                 
                                            borderGlow.setColor(Color.RED);
                                            r[whitekingrow][hup - k].setEffect(borderGlow);

                                            borderGlow.setColor(Color.BLUE);

                                        }
                                           System.out.println("CASTLE PEACHA JA RAHA 2");
                                        checkup++;
                                    }
                                }
                                if (checkup == 0 && hup - k >= 0) {
                                    r[whitekingrow][hup - k].setEffect(borderGlow);
                                    System.out.println("CASTLE PEACHA JA RAHA 8");

                                }

                                if (checkfirst1(root.getRowIndex(imwhiteking), whitekingrow, whitekingcolumn + 1, +1) == true || (checkblackcastle(root.getRowIndex(imwhiteking), root.getColumnIndex(imwhiteking) + 1) == true) || (checkblackpawn(root.getRowIndex(imwhiteking), root.getColumnIndex(imwhiteking) + 1)) || (checkblackbishops(root.getRowIndex(imwhiteking), root.getColumnIndex(imwhiteking) + 1)) || (checkblackqueen(root.getRowIndex(imwhiteking), root.getColumnIndex(imwhiteking) + 1))) {
                                                                        System.out.println("CASTLE PEACHA JA RAHA 4");

                                    checkdown++;
                                    
                                }

                                for (int l = 0; l < blackimages.size(); l++) {

                                    if (checkdown == 0 && (GridPane.getRowIndex(blackimages.get(l)) == whitekingrow && GridPane.getColumnIndex(blackimages.get(l)) == hdown + k) || (GridPane.getRowIndex(whiteimages.get(l)) == whitekingrow && GridPane.getColumnIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7) {
                                        if (GridPane.getColumnIndex(blackimages.get(l)) == hdown + k && GridPane.getRowIndex(blackimages.get(l)) == whitekingrow) {
                                            borderGlow.setColor(Color.RED);
                                            r[whitekingrow][hdown + k].setEffect(borderGlow);
                                    System.out.println("CASTLE PEACHA JA RAHA 5");

                                            borderGlow.setColor(Color.BLUE);

                                        }
                                    System.out.println("CASTLE PEACHA JA RAHA 6");

                                        checkdown++;
                                    }

                                }
                                if (checkdown == 0 && hdown + k <= 7) {
                                    r[whitekingrow][hdown + k].setEffect(borderGlow);
                                    System.out.println("CASTLE PEACHA JA RAHA 7");

                                }
                            }//checking condition

                        }
                        //}
                        hup = root.getRowIndex(imwhiteking);
                        hdown = root.getRowIndex(imwhiteking);
                        checkup = 0;
                        checkdown = 0;
                        if (checkfirst1(root.getRowIndex(imwhiteking) - 1, whitekingrow, whitekingcolumn, 0) == true || (checkblackcastle(root.getRowIndex(imwhiteking) - 1, root.getColumnIndex(imwhiteking)) == true) || (checkblackpawn(root.getRowIndex(imwhiteking) - 1, root.getColumnIndex(imwhiteking))) || (checkblackbishops(root.getRowIndex(imwhiteking) - 1, root.getColumnIndex(imwhiteking))) || (checkblackqueen(root.getRowIndex(imwhiteking) - 1, root.getColumnIndex(imwhiteking)))) {
                            checkup++;
                        }

                        for (int k = 1; k <= 1; k++) {
                            if ((hup - k) >= 0 || hdown + k <= 7) {
                                for (int q = 0; q < blackimages.size(); q++) {
                                    if ((GridPane.getColumnIndex(blackimages.get(q)) == whitekingcolumn && GridPane.getRowIndex(blackimages.get(q)) == hup - k) || (GridPane.getColumnIndex(whiteimages.get(q)) == whitekingcolumn && GridPane.getRowIndex(whiteimages.get(q)) == hup - k) && hup - k >= 0 && checkup == 0) {
                                        if (GridPane.getRowIndex(blackimages.get(q)) == hup - k && GridPane.getColumnIndex(blackimages.get(q)) == whitekingcolumn) {
                                            borderGlow.setColor(Color.RED);
                                            r[hup - k][whitekingcolumn].setEffect(borderGlow);

                                            borderGlow.setColor(Color.BLUE);

                                        }
                                        checkup++;
                                    }
                                }
                                if (checkup == 0 && hup - k >= 0) {
                                    r[hup - k][whitekingcolumn].setEffect(borderGlow);

                                }
                                if (checkfirst1(root.getRowIndex(imwhiteking) + 1, whitekingrow, whitekingcolumn, 0) == true || (checkblackcastle(root.getRowIndex(imwhiteking) + 1, root.getColumnIndex(imwhiteking)) == true) || (checkblackpawn(root.getRowIndex(imwhiteking) + 1, root.getColumnIndex(imwhiteking))) || (checkblackbishops(root.getRowIndex(imwhiteking) + 1, root.getColumnIndex(imwhiteking))) || (checkblackqueen(root.getRowIndex(imwhiteking) + 1, root.getColumnIndex(imwhiteking)))) {
                                    checkdown++;
                                }
//                                   
                                for (int l = 0; l < blackimages.size(); l++) {
                                    if (checkdown == 0 && (GridPane.getColumnIndex(blackimages.get(l)) == whitekingcolumn && GridPane.getRowIndex(blackimages.get(l)) == hdown + k) || (GridPane.getColumnIndex(whiteimages.get(l)) == whitekingcolumn && GridPane.getRowIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7) {
                                        if (GridPane.getRowIndex(blackimages.get(l)) == hdown + k && GridPane.getColumnIndex(blackimages.get(l)) == whitekingcolumn) {
                                            borderGlow.setColor(Color.RED);
                                            r[hdown + k][whitekingcolumn].setEffect(borderGlow);

                                            borderGlow.setColor(Color.BLUE);

                                        } else {
                                        }
                                        checkdown++;
                                    }

                                }
                                if (checkdown == 0 && hdown + k <= 7) {
                                    r[hdown + k][whitekingcolumn].setEffect(borderGlow);

                                }
                            }//checking condition
                        }
                        hup = root.getColumnIndex(imwhiteking);
                        hdown = root.getColumnIndex(imwhiteking);
                        checkup = 0;
                        checkdown = 0;
                        checkup1 = 0;
                        checkdown1 = 0;
                        if (checkfirst1(root.getRowIndex(imwhiteking) - 1, whitekingrow, whitekingcolumn - 1, -1) == true || (checkblackcastle(root.getRowIndex(imwhiteking) - 1, root.getColumnIndex(imwhiteking) - 1) == true) || (checkblackpawn(root.getRowIndex(imwhiteking) - 1, root.getColumnIndex(imwhiteking) - 1)) || (checkblackbishops(root.getRowIndex(imwhiteking) - 1, root.getColumnIndex(imwhiteking) - 1)) || (checkblackqueen(root.getRowIndex(imwhiteking) - 1, root.getColumnIndex(imwhiteking) - 1))) {
                            checkup++;
                        }
                        for (int k = 1; k <= 1; k++) {
                            //    for (int t = 0; t < blackimages.size(); t++) {
                            if ((hup - k) >= 0 || hdown + k <= 7) {
                                //    System.out.println("ahmad");
                                for (int q = 0; q < blackimages.size(); q++) {
                                    //      System.out.println("faraz");
                                    if (whitekingrow - k >= 0 && (GridPane.getRowIndex(blackimages.get(q)) == whitekingrow - k && GridPane.getColumnIndex(blackimages.get(q)) == hup - k) || (GridPane.getRowIndex(whiteimages.get(q)) == whitekingrow - k && GridPane.getColumnIndex(whiteimages.get(q)) == hup - k) && hup - k >= 0 && checkup == 0) // if(GridPane.getColumnIndex(whiteimages.get(q))==column&&GridPane.getRowIndex(whiteimages.get(q))==hup-k&&hup-k>=0&&checkup==0&&GridPane.getColumnIndex(blackimages.get(q))!=GridPane.getColumnIndex(blackimages)//&&blackimages.get(q)!=img) 
                                    {
                                        //        System.out.println("talha");
                                        if (GridPane.getColumnIndex(blackimages.get(q)) == hup - k && GridPane.getRowIndex(blackimages.get(q)) == whitekingrow - k) {
                                            //          System.out.println("fazool");
                                            borderGlow.setColor(Color.RED);
                                            r[whitekingrow - k][hup - k].setEffect(borderGlow);

                                            borderGlow.setColor(Color.BLUE);

                                        }
                                        checkup++;
                                    }
                                }
                                if (checkup == 0 && hup - k >= 0 && whitekingrow - k >= 0) {
                                    //System.out.println("huziafa");
                                    r[whitekingrow - k][hup - k].setEffect(borderGlow);

                                }
                                if (checkfirst1(root.getRowIndex(imwhiteking) - 1, whitekingrow, whitekingcolumn + 1, +1) == true || (checkblackcastle(root.getRowIndex(imwhiteking) - 1, root.getColumnIndex(imwhiteking) + 1) == true) || (checkblackpawn(root.getRowIndex(imwhiteking) - 1, root.getColumnIndex(imwhiteking) + 1)) || (checkblackbishops(root.getRowIndex(imwhiteking) - 1, root.getColumnIndex(imwhiteking) + 1)) || (checkblackqueen(root.getRowIndex(imwhiteking) - 1, root.getColumnIndex(imwhiteking) + 1))) {
                                    checkdown++;
                                }
                                for (int l = 0; l < blackimages.size(); l++) {

                                    //System.out.println("owais");
                                    if (whitekingrow - k >= 0 && (GridPane.getRowIndex(blackimages.get(l)) == whitekingrow - k && GridPane.getColumnIndex(blackimages.get(l)) == hdown + k) || (GridPane.getRowIndex(whiteimages.get(l)) == whitekingrow - k && GridPane.getColumnIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7 && checkdown == 0) {
                                        // System.out.println("sufiyan");
                                        if (GridPane.getColumnIndex(blackimages.get(l)) == hdown + k && GridPane.getRowIndex(blackimages.get(l)) == whitekingrow - k) {
                                            borderGlow.setColor(Color.RED);
                                            r[whitekingrow - k][hdown + k].setEffect(borderGlow);

                                            borderGlow.setColor(Color.BLUE);

                                        }

                                        checkdown++;
                                    }

                                }
                                if (checkdown == 0 && hdown + k <= 7 && whitekingrow - k >= 0) {
                                    // System.out.println("fizan");
                                    r[whitekingrow - k][hdown + k].setEffect(borderGlow);

                                }
                                if (checkfirst1(root.getRowIndex(imwhiteking) + 1, whitekingrow, whitekingcolumn - 1, -1) == true || (checkblackcastle(root.getRowIndex(imwhiteking) + 1, root.getColumnIndex(imwhiteking) - 1) == true) || (checkblackpawn(root.getRowIndex(imwhiteking) + 1, root.getColumnIndex(imwhiteking) - 1)) || (checkblackbishops(root.getRowIndex(imwhiteking) + 1, root.getColumnIndex(imwhiteking) - 1)) || (checkblackqueen(root.getRowIndex(imwhiteking) + 1, root.getColumnIndex(imwhiteking) - 1))) {
                                    checkup1++;
                                }

                                for (int q = 0; q < blackimages.size(); q++) {
                                    //      System.out.println("faraz");
                                    if (whitekingrow + k <= 7 && (GridPane.getRowIndex(blackimages.get(q)) == whitekingrow + k && GridPane.getColumnIndex(blackimages.get(q)) == hup - k) || (GridPane.getRowIndex(whiteimages.get(q)) == whitekingrow + k && GridPane.getColumnIndex(whiteimages.get(q)) == hup - k) && hup - k >= 0 && checkup1 == 0) // if(GridPane.getColumnIndex(whiteimages.get(q))==column&&GridPane.getRowIndex(whiteimages.get(q))==hup-k&&hup-k>=0&&checkup==0&&GridPane.getColumnIndex(blackimages.get(q))!=GridPane.getColumnIndex(blackimages)//&&blackimages.get(q)!=img) 
                                    {
                                        //        System.out.println("talha");
                                        if (GridPane.getColumnIndex(blackimages.get(q)) == hup - k && GridPane.getRowIndex(blackimages.get(q)) == whitekingrow + k) {
                                            //          System.out.println("fazool");
                                            borderGlow.setColor(Color.RED);
                                            r[whitekingrow + k][hup - k].setEffect(borderGlow);

                                            borderGlow.setColor(Color.BLUE);

                                        }
                                        checkup1++;
                                    }
                                }
                                if (checkup1 == 0 && hup - k >= 0 && whitekingrow + k <= 7) {
                                    //System.out.println("huziafa");
                                    r[whitekingrow + k][hup - k].setEffect(borderGlow);

                                }
//                                    if( checkfirst1(hup+1,root.getRowIndex(imwhiteking)+1,whitekingrow,whitekingcolumn)==true)
                                if (checkfirst1(root.getRowIndex(imwhiteking) + 1, whitekingrow, whitekingcolumn + 1, +1) == true || (checkblackcastle(root.getRowIndex(imwhiteking) + 1, root.getColumnIndex(imwhiteking) + 1) == true) || (checkblackpawn(root.getRowIndex(imwhiteking) + 1, root.getColumnIndex(imwhiteking) + 1)) || (checkblackbishops(root.getRowIndex(imwhiteking) + 1, root.getColumnIndex(imwhiteking) + 1)) || (checkblackqueen(root.getRowIndex(imwhiteking) + 1, root.getColumnIndex(imwhiteking) + 1))) {
                                    checkdown1++;
                                }
                                for (int l = 0; l < blackimages.size(); l++) {

                                    //System.out.println("owais");
                                    if (whitekingrow + k <= 7 && checkdown1 == 0 && (GridPane.getRowIndex(blackimages.get(l)) == whitekingrow + k && GridPane.getColumnIndex(blackimages.get(l)) == hdown + k) || (GridPane.getRowIndex(whiteimages.get(l)) == whitekingrow + k && GridPane.getColumnIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7) {
                                        // System.out.println("sufiyan");
                                        if (GridPane.getColumnIndex(blackimages.get(l)) == hdown + k && GridPane.getRowIndex(blackimages.get(l)) == whitekingrow + k) {
                                            borderGlow.setColor(Color.RED);
                                            r[whitekingrow + k][hdown + k].setEffect(borderGlow);

                                            borderGlow.setColor(Color.BLUE);

                                        }

                                        checkdown1++;
                                    }

                                }
                                if (checkdown1 == 0 && hdown + k <= 7 && whitekingrow + k <= 7) {
                                    // System.out.println("fizan");
                                    r[whitekingrow + k][hdown + k].setEffect(borderGlow);

                                }

                            }
                            if (checkup != 0 && checkdown != 0 && checkup1 != 0 && checkdown1 != 0) {
                                break;
                            }
                        }

                    }
                }
            }
        });

//img.setX(10);
//img.setY(10);
//img.setOnMouseReleased(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//         if(event.getButton()==MouseButton.PRIMARY){
//         
//             System.out.println("oye");
//         }
//            }
//        });
//        imwhitequeen.setOnMousePressed(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                if (imwhitequeen.isPressed()) {
//                    if (opposite.equals("white")) {
//                        clear();
//                        name = "whitequeen";
//                        checkup = 0;
//                        checkdown = 0;
//                        checkup1 = 0;
//                        checkdown1 = 0;
//
//                        int hup = root.getColumnIndex(imwhitequeen);
//                        int hdown = root.getColumnIndex(imwhitequeen);
//
//                        for (int k = 1; k < r.length; k++) {
//                            //    for (int t = 0; t < blackimages.size(); t++) {
//                            if ((hup - k) >= 0 || hdown + k <= 7) {
//                                //    System.out.println("ahmad");
//                                for (int q = 0; q < blackimages.size(); q++) {
//                                    //      System.out.println("faraz");
//                                    if ((GridPane.getRowIndex(blackimages.get(q)) == rowwhitequeen && GridPane.getColumnIndex(blackimages.get(q)) == hup - k) || (GridPane.getRowIndex(whiteimages.get(q)) == rowwhitequeen && GridPane.getColumnIndex(whiteimages.get(q)) == hup - k) && hup - k >= 0 && checkup == 0) {
//                                        if (GridPane.getColumnIndex(blackimages.get(q)) == hup - k && GridPane.getRowIndex(blackimages.get(q)) == rowwhitequeen) {
//                                            borderGlow.setColor(Color.RED);
//                                            r[rowwhitequeen][hup - k].setEffect(borderGlow);
//
//                                            borderGlow.setColor(Color.BLUE);
//
//                                        }
//                                        checkup++;
//                                    }
//                                }
//                                if (checkup == 0 && hup - k >= 0) {
//                                    r[rowwhitequeen][hup - k].setEffect(borderGlow);
//
//                                }
//
//                                for (int l = 0; l < blackimages.size(); l++) {
//
//                                    if (checkdown == 0 && (GridPane.getRowIndex(blackimages.get(l)) == rowwhitequeen && GridPane.getColumnIndex(blackimages.get(l)) == hdown + k) || (GridPane.getRowIndex(whiteimages.get(l)) == rowwhitequeen && GridPane.getColumnIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7) {
//                                        if (GridPane.getColumnIndex(blackimages.get(l)) == hdown + k && GridPane.getRowIndex(blackimages.get(l)) == rowwhitequeen) {
//                                            borderGlow.setColor(Color.RED);
//                                            r[rowwhitequeen][hdown + k].setEffect(borderGlow);
//
//                                            borderGlow.setColor(Color.BLUE);
//
//                                        }
//
//                                        checkdown++;
//                                    }
//
//                                }
//                                if (checkdown == 0 && hdown + k <= 7) {
//                                    r[rowwhitequeen][hdown + k].setEffect(borderGlow);
//
//                                }
//                            }//checking condition
//
//                            if (checkup != 0 && checkdown != 0) {
//                                break;
//                            }
//
//                        }
//                        //}
//                        hup = root.getRowIndex(imwhitequeen);
//                        hdown = root.getRowIndex(imwhitequeen);
//                        checkup = 0;
//                        checkdown = 0;
//
//                        for (int k = 1; k < r.length; k++) {
//                            if ((hup - k) >= 0 || hdown + k <= 7) {
//                                for (int q = 0; q < blackimages.size(); q++) {
//                                    if ((GridPane.getColumnIndex(blackimages.get(q)) == columnwhitequeen && GridPane.getRowIndex(blackimages.get(q)) == hup - k) || (GridPane.getColumnIndex(whiteimages.get(q)) == columnwhitequeen && GridPane.getRowIndex(whiteimages.get(q)) == hup - k) && hup - k >= 0 && checkup == 0) {
//                                        if (GridPane.getRowIndex(blackimages.get(q)) == hup - k && GridPane.getColumnIndex(blackimages.get(q)) == columnwhitequeen) {
//                                            borderGlow.setColor(Color.RED);
//                                            r[hup - k][columnwhitequeen].setEffect(borderGlow);
//
//                                            borderGlow.setColor(Color.BLUE);
//
//                                        }
//                                        checkup++;
//                                    }
//                                }
//                                if (checkup == 0 && hup - k >= 0) {
//                                    r[hup - k][columnwhitequeen].setEffect(borderGlow);
//
//                                }
//
//                                for (int l = 0; l < blackimages.size(); l++) {
//                                    if (checkdown == 0 && (GridPane.getColumnIndex(blackimages.get(l)) == columnwhitequeen && GridPane.getRowIndex(blackimages.get(l)) == hdown + k) || (GridPane.getColumnIndex(whiteimages.get(l)) == columnwhitequeen && GridPane.getRowIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7) {
//                                        if (GridPane.getRowIndex(blackimages.get(l)) == hdown + k && GridPane.getColumnIndex(blackimages.get(l)) == columnwhitequeen) {
//                                            borderGlow.setColor(Color.RED);
//                                            r[hdown + k][columnwhitequeen].setEffect(borderGlow);
//
//                                            borderGlow.setColor(Color.BLUE);
//
//                                        } else {
//                                        }
//                                        checkdown++;
//                                    }
//
//                                }
//                                if (checkdown == 0 && hdown + k <= 7) {
//                                    r[hdown + k][columnwhitequeen].setEffect(borderGlow);
//
//                                }
//                            }//checking condition
//                        }
//                        hup = root.getColumnIndex(imwhitequeen);
//                        hdown = root.getColumnIndex(imwhitequeen);
//                        checkup = 0;
//                        checkdown = 0;
//                        checkup1 = 0;
//                        checkdown1 = 0;
//
//                        for (int k = 1; k < r.length; k++) {
//                            //    for (int t = 0; t < blackimages.size(); t++) {
//                            if ((hup - k) >= 0 || hdown + k <= 7) {
//                                //    System.out.println("ahmad");
//                                for (int q = 0; q < blackimages.size(); q++) {
//                                    //      System.out.println("faraz");
//                                    if (rowwhitequeen - k >= 0 && (GridPane.getRowIndex(blackimages.get(q)) == rowwhitequeen - k && GridPane.getColumnIndex(blackimages.get(q)) == hup - k) || (GridPane.getRowIndex(whiteimages.get(q)) == rowwhitequeen - k && GridPane.getColumnIndex(whiteimages.get(q)) == hup - k) && hup - k >= 0 && checkup == 0) // if(GridPane.getColumnIndex(whiteimages.get(q))==column&&GridPane.getRowIndex(whiteimages.get(q))==hup-k&&hup-k>=0&&checkup==0&&GridPane.getColumnIndex(blackimages.get(q))!=GridPane.getColumnIndex(blackimages)//&&blackimages.get(q)!=img) 
//                                    {
//                                        //        System.out.println("talha");
//                                        if (GridPane.getColumnIndex(blackimages.get(q)) == hup - k && GridPane.getRowIndex(blackimages.get(q)) == rowwhitequeen - k) {
//                                            //          System.out.println("fazool");
//                                            borderGlow.setColor(Color.RED);
//                                            r[rowwhitequeen - k][hup - k].setEffect(borderGlow);
//
//                                            borderGlow.setColor(Color.BLUE);
//
//                                        }
//                                        checkup++;
//                                    }
//                                }
//                                if (checkup == 0 && hup - k >= 0 && rowwhitequeen - k >= 0) {
//                                    //System.out.println("huziafa");
//                                    r[rowwhitequeen - k][hup - k].setEffect(borderGlow);
//
//                                }
//
//                                for (int l = 0; l < blackimages.size(); l++) {
//
//                                    //System.out.println("owais");
//                                    if (rowwhitequeen - k >= 0 && (GridPane.getRowIndex(blackimages.get(l)) == rowwhitequeen - k && GridPane.getColumnIndex(blackimages.get(l)) == hdown + k) || (GridPane.getRowIndex(whiteimages.get(l)) == rowwhitequeen - k && GridPane.getColumnIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7 && checkdown == 0) {
//                                        // System.out.println("sufiyan");
//                                        if (GridPane.getColumnIndex(blackimages.get(l)) == hdown + k && GridPane.getRowIndex(blackimages.get(l)) == rowwhitequeen - k) {
//                                            borderGlow.setColor(Color.RED);
//                                            r[rowwhitequeen - k][hdown + k].setEffect(borderGlow);
//
//                                            borderGlow.setColor(Color.BLUE);
//
//                                        }
//
//                                        checkdown++;
//                                    }
//
//                                }
//                                if (checkdown == 0 && hdown + k <= 7 && rowwhitequeen - k >= 0) {
//                                    // System.out.println("fizan");
//                                    r[rowwhitequeen - k][hdown + k].setEffect(borderGlow);
//
//                                }
//
//                                for (int q = 0; q < blackimages.size(); q++) {
//                                    //      System.out.println("faraz");
//                                    if (rowwhitequeen + k <= 7 && (GridPane.getRowIndex(blackimages.get(q)) == rowwhitequeen + k && GridPane.getColumnIndex(blackimages.get(q)) == hup - k) || (GridPane.getRowIndex(whiteimages.get(q)) == rowwhitequeen + k && GridPane.getColumnIndex(whiteimages.get(q)) == hup - k) && hup - k >= 0 && checkup1 == 0) // if(GridPane.getColumnIndex(whiteimages.get(q))==column&&GridPane.getRowIndex(whiteimages.get(q))==hup-k&&hup-k>=0&&checkup==0&&GridPane.getColumnIndex(blackimages.get(q))!=GridPane.getColumnIndex(blackimages)//&&blackimages.get(q)!=img) 
//                                    {
//                                        //        System.out.println("talha");
//                                        if (GridPane.getColumnIndex(blackimages.get(q)) == hup - k && GridPane.getRowIndex(blackimages.get(q)) == rowwhitequeen + k) {
//                                            //          System.out.println("fazool");
//                                            borderGlow.setColor(Color.RED);
//                                            r[rowwhitequeen + k][hup - k].setEffect(borderGlow);
//
//                                            borderGlow.setColor(Color.BLUE);
//
//                                        }
//                                        checkup1++;
//                                    }
//                                }
//                                if (checkup1 == 0 && hup - k >= 0 && rowwhitequeen + k <= 7) {
//                                    //System.out.println("huziafa");
//                                    r[rowwhitequeen + k][hup - k].setEffect(borderGlow);
//
//                                }
//
//                                for (int l = 0; l < blackimages.size(); l++) {
//
//                                    //System.out.println("owais");
//                                    if (rowwhitequeen + k <= 7 && checkdown1 == 0 && (GridPane.getRowIndex(blackimages.get(l)) == rowwhitequeen + k && GridPane.getColumnIndex(blackimages.get(l)) == hdown + k) || (GridPane.getRowIndex(whiteimages.get(l)) == rowwhitequeen + k && GridPane.getColumnIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7) {
//                                        // System.out.println("sufiyan");
//                                        if (GridPane.getColumnIndex(blackimages.get(l)) == hdown + k && GridPane.getRowIndex(blackimages.get(l)) == rowwhitequeen + k) {
//                                            borderGlow.setColor(Color.RED);
//                                            r[rowwhitequeen + k][hdown + k].setEffect(borderGlow);
//
//                                            borderGlow.setColor(Color.BLUE);
//
//                                        }
//
//                                        checkdown1++;
//                                    }
//
//                                }
//                                if (checkdown1 == 0 && hdown + k <= 7 && rowwhitequeen + k <= 7) {
//                                    // System.out.println("fizan");
//                                    r[rowwhitequeen + k][hdown + k].setEffect(borderGlow);
//
//                                }
//
//                            }
//                            if (checkup != 0 && checkdown != 0 && checkup1 != 0 && checkdown1 != 0) {
//                                break;
//                            }
//                        }
//
//                    }
//                }
//            }
//        });
        imgwhitehorse.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (imgwhitehorse.isPressed()) {
                    if (opposite.equals("white")) {
                        clear();
                        name = "whitehorse";
                        for (int i = 0; i < r.length; i++) {
                            for (int j = 0; j < r[i].length; j++) {
                                if (i == rowwhitehorse) {
                                    checkup = 0;
                                    checkup1 = 0;
                                    checkdown = 0;
                                    checkdown1 = 0;
                                    int hup = root.getColumnIndex(imgwhitehorse);
                                    int hdown = root.getColumnIndex(imgwhitehorse);

                                    for (int k = 2; k <= 2; k++) {
                                        // for (int t = 0; t < blackimages.size(); t++) {
                                        if ((hup - k) >= 0 || hdown + k <= 7) {
                                            for (int q = 0; q < blackimages.size(); q++) {
                                                if ((GridPane.getRowIndex(blackimages.get(q)) == rowwhitehorse - 1 && GridPane.getColumnIndex(blackimages.get(q)) == hup - k) || (GridPane.getRowIndex(whiteimages.get(q)) == rowwhitehorse - 1 && GridPane.getColumnIndex(whiteimages.get(q)) == hup - k) && hup - k >= 0 && checkup == 0 && rowwhitehorse - 1 >= 0) {

                                                    if (GridPane.getColumnIndex(blackimages.get(q)) == hup - k && GridPane.getRowIndex(blackimages.get(q)) == rowwhitehorse - 1) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[rowwhitehorse - 1][hup - k].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }
                                                    checkup++;
                                                }
                                            }
                                            if (checkup == 0 && hup - k >= 0 && rowwhitehorse - 1 >= 0) {
                                                r[rowwhitehorse - 1][hup - k].setEffect(borderGlow);

                                            }

                                            for (int l = 0; l < blackimages.size(); l++) {

                                                if (checkdown == 0 && rowwhitehorse - 1 >= 0 && (GridPane.getRowIndex(blackimages.get(l)) == rowwhitehorse - 1 && GridPane.getColumnIndex(blackimages.get(l)) == hdown + k) || (GridPane.getRowIndex(whiteimages.get(l)) == rowwhitehorse - 1 && GridPane.getColumnIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7) {
                                                    if (GridPane.getColumnIndex(blackimages.get(l)) == hdown + k && GridPane.getRowIndex(blackimages.get(l)) == rowwhitehorse - 1) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[rowwhitehorse - 1][hdown + k].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    } else {
                                                    }
                                                    checkdown++;
                                                }

                                            }
                                            if (checkdown == 0 && hdown + k <= 7 && rowwhitehorse - 1 >= 0) {
                                                r[rowwhitehorse - 1][hdown + k].setEffect(borderGlow);

                                            }
                                            //////////////////////
                                            for (int q = 0; q < blackimages.size(); q++) {
                                                if ((GridPane.getRowIndex(blackimages.get(q)) == rowwhitehorse + 1 && GridPane.getColumnIndex(blackimages.get(q)) == hup - k) || (GridPane.getRowIndex(whiteimages.get(q)) == rowwhitehorse + 1 && GridPane.getColumnIndex(whiteimages.get(q)) == hup - k) && hup - k >= 0 && checkup1 == 0 && rowwhitehorse + 1 <= 7) {

                                                    if (GridPane.getColumnIndex(blackimages.get(q)) == hup - k && GridPane.getRowIndex(blackimages.get(q)) == rowwhitehorse + 1) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[rowwhitehorse + 1][hup - k].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }
                                                    checkup1++;
                                                }
                                            }
                                            if (checkup1 == 0 && hup - k >= 0 && rowwhitehorse + 1 <= 7) {
                                                r[rowwhitehorse + 1][hup - k].setEffect(borderGlow);

                                            }

                                            for (int l = 0; l < blackimages.size(); l++) {

                                                if (rowwhitehorse + 1 <= 7 && checkdown1 == 0 && (GridPane.getRowIndex(blackimages.get(l)) == rowwhitehorse + 1 && GridPane.getColumnIndex(blackimages.get(l)) == hdown + k) || (GridPane.getRowIndex(whiteimages.get(l)) == rowwhitehorse + 1 && GridPane.getColumnIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7) {
                                                    if (GridPane.getColumnIndex(blackimages.get(l)) == hdown + k && GridPane.getRowIndex(blackimages.get(l)) == rowwhitehorse + 1) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[rowwhitehorse + 1][hdown + k].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    } else {
                                                    }
                                                    checkdown1++;
                                                }

                                            }
                                            if (checkdown1 == 0 && hdown + k <= 7 && rowwhitehorse + 1 <= 7) {
                                                r[rowwhitehorse + 1][hdown + k].setEffect(borderGlow);

                                            }
                                        }//checking condition

                                        if (checkup != 0 && checkdown != 0 && checkup1 != 0 && checkdown != 0) {
                                            break;
                                        }

//                               
                                        //    }
                                    }
                                }
                                int hup = root.getRowIndex(imgwhitehorse);
                                int hdown = root.getRowIndex(imgwhitehorse);
                                if (j == columnwhitehorse) {
                                    checkup = 0;
                                    checkup1 = 0;
                                    checkdown = 0;
                                    checkdown1 = 0;

                                    for (int k = 2; k <= 2; k++) {
                                        // for (int t = 0; t < blackimages.size(); t++) {
                                        if ((hup - k) >= 0 || hdown + k <= 7) {
                                            for (int q = 0; q < blackimages.size(); q++) {
                                                if (columnwhitehorse - 1 >= 0 && (GridPane.getColumnIndex(blackimages.get(q)) == columnwhitehorse - 1 && GridPane.getRowIndex(blackimages.get(q)) == hup - k) || (GridPane.getColumnIndex(whiteimages.get(q)) == columnwhitehorse - 1 && GridPane.getRowIndex(whiteimages.get(q)) == hup - k) && hup - k >= 0 && checkup == 0) {

                                                    if (GridPane.getRowIndex(blackimages.get(q)) == hup - k && GridPane.getColumnIndex(blackimages.get(q)) == columnwhitehorse - 1) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[hup - k][columnwhitehorse - 1].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }
                                                    checkup++;
                                                }
                                            }
                                            if (columnwhitehorse - 1 >= 0 && checkup == 0 && hup - k >= 0) {
                                                r[hup - k][columnwhitehorse - 1].setEffect(borderGlow);

                                            }

                                            for (int l = 0; l < blackimages.size(); l++) {

                                                if (columnwhitehorse - 1 >= 0 && checkdown == 0 && (GridPane.getColumnIndex(blackimages.get(l)) == columnwhitehorse - 1 && GridPane.getRowIndex(blackimages.get(l)) == hdown + k) || (GridPane.getColumnIndex(whiteimages.get(l)) == columnwhitehorse - 1 && GridPane.getRowIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7) {
                                                    if (GridPane.getRowIndex(blackimages.get(l)) == hdown + k && GridPane.getColumnIndex(blackimages.get(l)) == columnwhitehorse - 1) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[hdown + k][columnwhitehorse - 1].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    } else {
                                                    }
                                                    checkdown++;
                                                }

                                            }
                                            if (columnwhitehorse - 1 >= 0 && checkdown == 0 && hdown + k <= 7) {
                                                r[hdown + k][columnwhitehorse - 1].setEffect(borderGlow);

                                            }
                                            //////////////////////
                                            for (int q = 0; q < blackimages.size(); q++) {
                                                if (columnwhitehorse + 1 <= 7 && (GridPane.getColumnIndex(blackimages.get(q)) == columnwhitehorse + 1 && GridPane.getRowIndex(blackimages.get(q)) == hup - k) || (GridPane.getColumnIndex(whiteimages.get(q)) == columnwhitehorse + 1 && GridPane.getRowIndex(whiteimages.get(q)) == hup - k) && hup - k >= 0 && checkup1 == 0) {

                                                    if (GridPane.getRowIndex(blackimages.get(q)) == hup - k && GridPane.getColumnIndex(blackimages.get(q)) == columnwhitehorse + 1) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[hup - k][columnwhitehorse + 1].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }
                                                    checkup1++;
                                                }
                                            }
                                            if (columnwhitehorse + 1 <= 7 && checkup1 == 0 && hup - k >= 0) {
                                                r[hup - k][columnwhitehorse + 1].setEffect(borderGlow);

                                            }

                                            for (int l = 0; l < blackimages.size(); l++) {

                                                if (columnwhitehorse + 1 <= 7 && checkdown1 == 0 && (GridPane.getColumnIndex(blackimages.get(l)) == columnwhitehorse + 1 && GridPane.getRowIndex(blackimages.get(l)) == hdown + k) || (GridPane.getColumnIndex(whiteimages.get(l)) == columnwhitehorse + 1 && GridPane.getRowIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7) {
                                                    if (GridPane.getRowIndex(blackimages.get(l)) == hdown + k && GridPane.getColumnIndex(blackimages.get(l)) == columnwhitehorse + 1) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[hdown + k][columnwhitehorse + 1].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    } else {
                                                    }
                                                    checkdown1++;
                                                }

                                            }
                                            if (columnwhitehorse + 1 <= 7 && checkdown1 == 0 && hdown + k <= 7) {
                                                r[hdown + k][columnwhitehorse + 1].setEffect(borderGlow);

                                            }
                                        }//checking condition

                                        if (checkup != 0 && checkdown != 0 && checkup1 != 0 && checkdown1 != 0) {
                                            break;
                                        }

//                               
                                        //    }
                                    }
                                }

                            }
                        }
                    }
                }
            }
        });

        imgwhitehorse1.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (imgwhitehorse1.isPressed()) {
                    if (opposite.equals("white")) {
                        clear();
                        name = "whitehorse1";
                        for (int i = 0; i < r.length; i++) {
                            for (int j = 0; j < r[i].length; j++) {
                                if (i == rowwhitehorse1) {
                                    checkup = 0;
                                    checkup1 = 0;
                                    checkdown = 0;
                                    checkdown1 = 0;
                                    int hup = root.getColumnIndex(imgwhitehorse1);
                                    int hdown = root.getColumnIndex(imgwhitehorse1);

                                    for (int k = 2; k <= 2; k++) {
                                        // for (int t = 0; t < blackimages.size(); t++) {
                                        if ((hup - k) >= 0 || hdown + k <= 7) {
                                            for (int q = 0; q < blackimages.size(); q++) {
                                                if ((GridPane.getRowIndex(blackimages.get(q)) == rowwhitehorse1 - 1 && GridPane.getColumnIndex(blackimages.get(q)) == hup - k) || (GridPane.getRowIndex(whiteimages.get(q)) == rowwhitehorse1 - 1 && GridPane.getColumnIndex(whiteimages.get(q)) == hup - k) && hup - k >= 0 && checkup == 0 && rowwhitehorse1 - 1 >= 0) {

                                                    if (GridPane.getColumnIndex(blackimages.get(q)) == hup - k && GridPane.getRowIndex(blackimages.get(q)) == rowwhitehorse1 - 1) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[rowwhitehorse1 - 1][hup - k].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }
                                                    checkup++;
                                                }
                                            }
                                            if (checkup == 0 && hup - k >= 0 && rowwhitehorse1 - 1 >= 0) {
                                                r[rowwhitehorse1 - 1][hup - k].setEffect(borderGlow);

                                            }

                                            for (int l = 0; l < blackimages.size(); l++) {

                                                if (checkdown == 0 && rowwhitehorse1 - 1 >= 0 && (GridPane.getRowIndex(blackimages.get(l)) == rowwhitehorse1 - 1 && GridPane.getColumnIndex(blackimages.get(l)) == hdown + k) || (GridPane.getRowIndex(whiteimages.get(l)) == rowwhitehorse1 - 1 && GridPane.getColumnIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7) {
                                                    if (GridPane.getColumnIndex(blackimages.get(l)) == hdown + k && GridPane.getRowIndex(blackimages.get(l)) == rowwhitehorse1 - 1) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[rowwhitehorse1 - 1][hdown + k].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    } else {
                                                    }
                                                    checkdown++;
                                                }

                                            }
                                            if (checkdown == 0 && hdown + k <= 7 && rowwhitehorse1 - 1 >= 0) {
                                                r[rowwhitehorse1 - 1][hdown + k].setEffect(borderGlow);

                                            }
                                            //////////////////////
                                            for (int q = 0; q < blackimages.size(); q++) {
                                                if ((GridPane.getRowIndex(blackimages.get(q)) == rowwhitehorse1 + 1 && GridPane.getColumnIndex(blackimages.get(q)) == hup - k) || (GridPane.getRowIndex(whiteimages.get(q)) == rowwhitehorse1 + 1 && GridPane.getColumnIndex(whiteimages.get(q)) == hup - k) && hup - k >= 0 && checkup1 == 0 && rowwhitehorse1 + 1 <= 7) {

                                                    if (GridPane.getColumnIndex(blackimages.get(q)) == hup - k && GridPane.getRowIndex(blackimages.get(q)) == rowwhitehorse1 + 1) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[rowwhitehorse1 + 1][hup - k].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }
                                                    checkup1++;
                                                }
                                            }
                                            if (checkup1 == 0 && hup - k >= 0 && rowwhitehorse1 + 1 <= 7) {
                                                r[rowwhitehorse1 + 1][hup - k].setEffect(borderGlow);

                                            }

                                            for (int l = 0; l < blackimages.size(); l++) {

                                                if (rowwhitehorse1 + 1 <= 7 && checkdown1 == 0 && (GridPane.getRowIndex(blackimages.get(l)) == rowwhitehorse1 + 1 && GridPane.getColumnIndex(blackimages.get(l)) == hdown + k) || (GridPane.getRowIndex(whiteimages.get(l)) == rowwhitehorse1 + 1 && GridPane.getColumnIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7) {
                                                    if (GridPane.getColumnIndex(blackimages.get(l)) == hdown + k && GridPane.getRowIndex(blackimages.get(l)) == rowwhitehorse1 + 1) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[rowwhitehorse1 + 1][hdown + k].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    } else {
                                                    }
                                                    checkdown1++;
                                                }

                                            }
                                            if (checkdown1 == 0 && hdown + k <= 7 && rowwhitehorse1 + 1 <= 7) {
                                                r[rowwhitehorse1 + 1][hdown + k].setEffect(borderGlow);

                                            }
                                        }//checking condition

                                        if (checkup != 0 && checkdown != 0 && checkup1 != 0 && checkdown != 0) {
                                            break;
                                        }

//                               
                                        //    }
                                    }
                                }
                                int hup = root.getRowIndex(imgwhitehorse1);
                                int hdown = root.getRowIndex(imgwhitehorse1);
                                if (j == columnwhitehorse1) {
                                    checkup = 0;
                                    checkup1 = 0;
                                    checkdown = 0;
                                    checkdown1 = 0;

                                    for (int k = 2; k <= 2; k++) {
                                        // for (int t = 0; t < blackimages.size(); t++) {
                                        if ((hup - k) >= 0 || hdown + k <= 7) {
                                            for (int q = 0; q < blackimages.size(); q++) {
                                                if (columnwhitehorse1 - 1 >= 0 && (GridPane.getColumnIndex(blackimages.get(q)) == columnwhitehorse1 - 1 && GridPane.getRowIndex(blackimages.get(q)) == hup - k) || (GridPane.getColumnIndex(whiteimages.get(q)) == columnwhitehorse1 - 1 && GridPane.getRowIndex(whiteimages.get(q)) == hup - k) && hup - k >= 0 && checkup == 0) {

                                                    if (GridPane.getRowIndex(blackimages.get(q)) == hup - k && GridPane.getColumnIndex(blackimages.get(q)) == columnwhitehorse1 - 1) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[hup - k][columnwhitehorse1 - 1].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }
                                                    checkup++;
                                                }
                                            }
                                            if (columnwhitehorse1 - 1 >= 0 && checkup == 0 && hup - k >= 0) {
                                                r[hup - k][columnwhitehorse1 - 1].setEffect(borderGlow);

                                            }

                                            for (int l = 0; l < blackimages.size(); l++) {

                                                if (columnwhitehorse1 - 1 >= 0 && checkdown == 0 && (GridPane.getColumnIndex(blackimages.get(l)) == columnwhitehorse1 - 1 && GridPane.getRowIndex(blackimages.get(l)) == hdown + k) || (GridPane.getColumnIndex(whiteimages.get(l)) == columnwhitehorse1 - 1 && GridPane.getRowIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7) {
                                                    if (GridPane.getRowIndex(blackimages.get(l)) == hdown + k && GridPane.getColumnIndex(blackimages.get(l)) == columnwhitehorse1 - 1) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[hdown + k][columnwhitehorse1 - 1].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    } else {
                                                    }
                                                    checkdown++;
                                                }

                                            }
                                            if (columnwhitehorse1 - 1 >= 0 && checkdown == 0 && hdown + k <= 7) {
                                                r[hdown + k][columnwhitehorse1 - 1].setEffect(borderGlow);

                                            }
                                            //////////////////////
                                            for (int q = 0; q < blackimages.size(); q++) {
                                                if (columnwhitehorse1 + 1 <= 7 && (GridPane.getColumnIndex(blackimages.get(q)) == columnwhitehorse1 + 1 && GridPane.getRowIndex(blackimages.get(q)) == hup - k) || (GridPane.getColumnIndex(whiteimages.get(q)) == columnwhitehorse1 + 1 && GridPane.getRowIndex(whiteimages.get(q)) == hup - k) && hup - k >= 0 && checkup1 == 0) {

                                                    if (GridPane.getRowIndex(blackimages.get(q)) == hup - k && GridPane.getColumnIndex(blackimages.get(q)) == columnwhitehorse1 + 1) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[hup - k][columnwhitehorse1 + 1].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }
                                                    checkup1++;
                                                }
                                            }
                                            if (columnwhitehorse1 + 1 <= 7 && checkup1 == 0 && hup - k >= 0) {
                                                r[hup - k][columnwhitehorse1 + 1].setEffect(borderGlow);

                                            }

                                            for (int l = 0; l < blackimages.size(); l++) {

                                                if (columnwhitehorse1 + 1 <= 7 && checkdown1 == 0 && (GridPane.getColumnIndex(blackimages.get(l)) == columnwhitehorse1 + 1 && GridPane.getRowIndex(blackimages.get(l)) == hdown + k) || (GridPane.getColumnIndex(whiteimages.get(l)) == columnwhitehorse1 + 1 && GridPane.getRowIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7) {
                                                    if (GridPane.getRowIndex(blackimages.get(l)) == hdown + k && GridPane.getColumnIndex(blackimages.get(l)) == columnwhitehorse1 + 1) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[hdown + k][columnwhitehorse1 + 1].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    } else {
                                                    }
                                                    checkdown1++;
                                                }

                                            }
                                            if (columnwhitehorse1 + 1 <= 7 && checkdown1 == 0 && hdown + k <= 7) {
                                                r[hdown + k][columnwhitehorse1 + 1].setEffect(borderGlow);

                                            }
                                        }//checking condition

                                        if (checkup != 0 && checkdown != 0 && checkup1 != 0 && checkdown1 != 0) {
                                            break;
                                        }

//                               
                                        //    }
                                    }
                                }

                            }
                        }
                    }
                }
            }
        });

        imgwhitebishop.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (imgwhitebishop.isPressed()) {
                    if (opposite.equals("white")) {
                        name = "whitebishop";
                        clear();
                        for (int i = 0; i < r.length; i++) {
                            for (int j = 0; j < r[i].length; j++) {
                                if (j == rowwhitebishop) {
                                    checkup = 0;
                                    checkdown = 0;
                                    checkup1 = 0;
                                    checkdown1 = 0;
                                    int hup = root.getColumnIndex(imgwhitebishop);
                                    int hdown = root.getColumnIndex(imgwhitebishop);

                                    for (int k = 1; k < r[i].length; k++) {
                                        //    for (int t = 0; t < blackimages.size(); t++) {
                                        if ((hup - k) >= 0 || hdown + k <= 7) {
                                            //    System.out.println("ahmad");
                                            for (int q = 0; q < blackimages.size(); q++) {
                                                //      System.out.println("faraz");
                                                if (rowwhitebishop - k >= 0 && (GridPane.getRowIndex(blackimages.get(q)) == rowwhitebishop - k && GridPane.getColumnIndex(blackimages.get(q)) == hup - k) || (GridPane.getRowIndex(whiteimages.get(q)) == rowwhitebishop - k && GridPane.getColumnIndex(whiteimages.get(q)) == hup - k) && hup - k >= 0 && checkup == 0) // if(GridPane.getColumnIndex(whiteimages.get(q))==column&&GridPane.getRowIndex(whiteimages.get(q))==hup-k&&hup-k>=0&&checkup==0&&GridPane.getColumnIndex(blackimages.get(q))!=GridPane.getColumnIndex(blackimages)//&&blackimages.get(q)!=img) 
                                                {
                                                    //        System.out.println("talha");
                                                    if (GridPane.getColumnIndex(blackimages.get(q)) == hup - k && GridPane.getRowIndex(blackimages.get(q)) == rowwhitebishop - k) {
                                                        //          System.out.println("fazool");
                                                        borderGlow.setColor(Color.RED);
                                                        r[rowwhitebishop - k][hup - k].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }
                                                    checkup++;
                                                }
                                            }
                                            if (checkup == 0 && hup - k >= 0 && rowwhitebishop - k >= 0) {
                                                //System.out.println("huziafa");
                                                r[rowwhitebishop - k][hup - k].setEffect(borderGlow);

                                            }

                                            for (int l = 0; l < blackimages.size(); l++) {

                                                //System.out.println("owais");
                                                if (rowwhitebishop - k >= 0 && (GridPane.getRowIndex(blackimages.get(l)) == rowwhitebishop - k && GridPane.getColumnIndex(blackimages.get(l)) == hdown + k) || (GridPane.getRowIndex(whiteimages.get(l)) == rowwhitebishop - k && GridPane.getColumnIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7 && checkdown == 0) {
                                                    // System.out.println("sufiyan");
                                                    if (GridPane.getColumnIndex(blackimages.get(l)) == hdown + k && GridPane.getRowIndex(blackimages.get(l)) == rowwhitebishop - k) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[rowwhitebishop - k][hdown + k].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }

                                                    checkdown++;
                                                }

                                            }
                                            if (checkdown == 0 && hdown + k <= 7 && rowwhitebishop - k >= 0) {
                                                // System.out.println("fizan");
                                                r[rowwhitebishop - k][hdown + k].setEffect(borderGlow);

                                            }

                                            for (int q = 0; q < blackimages.size(); q++) {
                                                //      System.out.println("faraz");
                                                if (rowwhitebishop + k <= 7 && checkup1 == 0 && (GridPane.getRowIndex(blackimages.get(q)) == rowwhitebishop + k && GridPane.getColumnIndex(blackimages.get(q)) == hup - k) || (GridPane.getRowIndex(whiteimages.get(q)) == rowwhitebishop + k && GridPane.getColumnIndex(whiteimages.get(q)) == hup - k) && hup - k >= 0) // if(GridPane.getColumnIndex(whiteimages.get(q))==column&&GridPane.getRowIndex(whiteimages.get(q))==hup-k&&hup-k>=0&&checkup==0&&GridPane.getColumnIndex(blackimages.get(q))!=GridPane.getColumnIndex(blackimages)//&&blackimages.get(q)!=img) 
                                                {
                                                    //        System.out.println("talha");
                                                    if (GridPane.getColumnIndex(blackimages.get(q)) == hup - k && GridPane.getRowIndex(blackimages.get(q)) == rowwhitebishop + k) {
                                                        //          System.out.println("fazool");
                                                        borderGlow.setColor(Color.RED);
                                                        r[rowwhitebishop + k][hup - k].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }
                                                    checkup1++;
                                                }
                                            }
                                            if (checkup1 == 0 && hup - k >= 0 && rowwhitebishop + k <= 7) {
                                                //System.out.println("huziafa");
                                                r[rowwhitebishop + k][hup - k].setEffect(borderGlow);

                                            }

                                            for (int l = 0; l < blackimages.size(); l++) {

                                                //System.out.println("owais");
                                                if (rowwhitebishop + k <= 7 && checkdown1 == 0 && (GridPane.getRowIndex(blackimages.get(l)) == rowwhitebishop + k && GridPane.getColumnIndex(blackimages.get(l)) == hdown + k) || (GridPane.getRowIndex(whiteimages.get(l)) == rowwhitebishop + k && GridPane.getColumnIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7) {
                                                    // System.out.println("sufiyan");
                                                    if (GridPane.getColumnIndex(blackimages.get(l)) == hdown + k && GridPane.getRowIndex(blackimages.get(l)) == rowwhitebishop + k) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[rowwhitebishop + k][hdown + k].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }

                                                    checkdown1++;
                                                }

                                            }
                                            if (checkdown1 == 0 && hdown + k <= 7 && rowwhitebishop + k <= 7) {
                                                // System.out.println("fizan");
                                                r[rowwhitebishop + k][hdown + k].setEffect(borderGlow);

                                            }

                                        }
                                        if (checkup != 0 && checkdown != 0 && checkup1 != 0 && checkdown1 != 0) {
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });

        imgwhitebishop1.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (imgwhitebishop1.isPressed()) {
                    if (opposite.equals("white")) {
                        name = "whitebishop1";
                        clear();
                        for (int i = 0; i < r.length; i++) {
                            for (int j = 0; j < r[i].length; j++) {
                                if (j == rowwhitebishop1) {
                                    checkup = 0;
                                    checkdown = 0;
                                    checkup1 = 0;
                                    checkdown1 = 0;
                                    int hup = root.getColumnIndex(imgwhitebishop1);
                                    int hdown = root.getColumnIndex(imgwhitebishop1);

                                    for (int k = 1; k < r[i].length; k++) {
                                        //    for (int t = 0; t < blackimages.size(); t++) {
                                        if ((hup - k) >= 0 || hdown + k <= 7) {
                                            //    System.out.println("ahmad");
                                            for (int q = 0; q < blackimages.size(); q++) {
                                                //      System.out.println("faraz");
                                                if (rowwhitebishop1 - k >= 0 && (GridPane.getRowIndex(blackimages.get(q)) == rowwhitebishop1 - k && GridPane.getColumnIndex(blackimages.get(q)) == hup - k) || (GridPane.getRowIndex(whiteimages.get(q)) == rowwhitebishop1 - k && GridPane.getColumnIndex(whiteimages.get(q)) == hup - k) && hup - k >= 0 && checkup == 0) // if(GridPane.getColumnIndex(whiteimages.get(q))==column&&GridPane.getRowIndex(whiteimages.get(q))==hup-k&&hup-k>=0&&checkup==0&&GridPane.getColumnIndex(blackimages.get(q))!=GridPane.getColumnIndex(blackimages)//&&blackimages.get(q)!=img) 
                                                {
                                                    //        System.out.println("talha");
                                                    if (GridPane.getColumnIndex(blackimages.get(q)) == hup - k && GridPane.getRowIndex(blackimages.get(q)) == rowwhitebishop1 - k) {
                                                        //          System.out.println("fazool");
                                                        borderGlow.setColor(Color.RED);
                                                        r[rowwhitebishop1 - k][hup - k].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }
                                                    checkup++;
                                                }
                                            }
                                            if (checkup == 0 && hup - k >= 0 && rowwhitebishop1 - k >= 0) {
                                                //System.out.println("huziafa");
                                                r[rowwhitebishop1 - k][hup - k].setEffect(borderGlow);

                                            }

                                            for (int l = 0; l < blackimages.size(); l++) {

                                                //System.out.println("owais");
                                                if (rowwhitebishop1 - k >= 0 && (GridPane.getRowIndex(blackimages.get(l)) == rowwhitebishop1 - k && GridPane.getColumnIndex(blackimages.get(l)) == hdown + k) || (GridPane.getRowIndex(whiteimages.get(l)) == rowwhitebishop1 - k && GridPane.getColumnIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7 && checkdown == 0) {
                                                    // System.out.println("sufiyan");
                                                    if (GridPane.getColumnIndex(blackimages.get(l)) == hdown + k && GridPane.getRowIndex(blackimages.get(l)) == rowwhitebishop1 - k) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[rowwhitebishop1 - k][hdown + k].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }

                                                    checkdown++;
                                                }

                                            }
                                            if (checkdown == 0 && hdown + k <= 7 && rowwhitebishop1 - k >= 0) {
                                                // System.out.println("fizan");
                                                r[rowwhitebishop1 - k][hdown + k].setEffect(borderGlow);

                                            }

                                            for (int q = 0; q < blackimages.size(); q++) {
                                                //      System.out.println("faraz");
                                                if (rowwhitebishop1 + k <= 7 && checkup1 == 0 && (GridPane.getRowIndex(blackimages.get(q)) == rowwhitebishop1 + k && GridPane.getColumnIndex(blackimages.get(q)) == hup - k) || (GridPane.getRowIndex(whiteimages.get(q)) == rowwhitebishop1 + k && GridPane.getColumnIndex(whiteimages.get(q)) == hup - k) && hup - k >= 0) // if(GridPane.getColumnIndex(whiteimages.get(q))==column&&GridPane.getRowIndex(whiteimages.get(q))==hup-k&&hup-k>=0&&checkup==0&&GridPane.getColumnIndex(blackimages.get(q))!=GridPane.getColumnIndex(blackimages)//&&blackimages.get(q)!=img) 
                                                {
                                                    //        System.out.println("talha");
                                                    if (GridPane.getColumnIndex(blackimages.get(q)) == hup - k && GridPane.getRowIndex(blackimages.get(q)) == rowwhitebishop1 + k) {
                                                        //          System.out.println("fazool");
                                                        borderGlow.setColor(Color.RED);
                                                        r[rowwhitebishop1 + k][hup - k].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }
                                                    checkup1++;
                                                }
                                            }
                                            if (checkup1 == 0 && hup - k >= 0 && rowwhitebishop1 + k <= 7) {
                                                //System.out.println("huziafa");
                                                r[rowwhitebishop1 + k][hup - k].setEffect(borderGlow);

                                            }

                                            for (int l = 0; l < blackimages.size(); l++) {

                                                //System.out.println("owais");
                                                if (rowwhitebishop1 + k <= 7 && checkdown1 == 0 && (GridPane.getRowIndex(blackimages.get(l)) == rowwhitebishop1 + k && GridPane.getColumnIndex(blackimages.get(l)) == hdown + k) || (GridPane.getRowIndex(whiteimages.get(l)) == rowwhitebishop1 + k && GridPane.getColumnIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7) {
                                                    // System.out.println("sufiyan");
                                                    if (GridPane.getColumnIndex(blackimages.get(l)) == hdown + k && GridPane.getRowIndex(blackimages.get(l)) == rowwhitebishop1 + k) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[rowwhitebishop1 + k][hdown + k].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }

                                                    checkdown1++;
                                                }

                                            }
                                            if (checkdown1 == 0 && hdown + k <= 7 && rowwhitebishop1 + k <= 7) {
                                                // System.out.println("fizan");
                                                r[rowwhitebishop1 + k][hdown + k].setEffect(borderGlow);

                                            }

                                        }
                                        if (checkup != 0 && checkdown != 0 && checkup1 != 0 && checkdown1 != 0) {
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });

//else if(opposite.equals("black"))
//{
//     System.out.println(opposite);   
        img1.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (img1.isPressed()) {
                    if (opposite.equals("black")) {
                        clear();
                        name = "blackcastle1";
                        checkup = 0;

                        checkdown = 0;
                        checkup1 = 0;

                        checkdown1 = 0;

                        int hup = root.getColumnIndex(img1);
                        int hdown = root.getColumnIndex(img1);

                        for (int k = 1; k < r.length; k++) {
                            //    for (int t = 0; t < blackimages.size(); t++) {
                            if ((hup - k) >= 0 || hdown + k <= 7) {
                                //    System.out.println("ahmad");
                                for (int q = 0; q < blackimages.size(); q++) {
                                    //      System.out.println("faraz");
                                    if ((GridPane.getRowIndex(blackimages.get(q)) == blackcastlerow && GridPane.getColumnIndex(blackimages.get(q)) == hup - k) || (GridPane.getRowIndex(whiteimages.get(q)) == blackcastlerow && GridPane.getColumnIndex(whiteimages.get(q)) == hup - k) && hup - k >= 0 && checkup == 0) {
                                        if (GridPane.getColumnIndex(whiteimages.get(q)) == hup - k && GridPane.getRowIndex(whiteimages.get(q)) == blackcastlerow) {
                                            borderGlow.setColor(Color.RED);
                                            r[blackcastlerow][hup - k].setEffect(borderGlow);

                                            borderGlow.setColor(Color.BLUE);

                                        }
                                        checkup++;
                                    }
                                }
                                if (checkup == 0 && hup - k >= 0) {
                                    r[blackcastlerow][hup - k].setEffect(borderGlow);

                                }

                                for (int l = 0; l < blackimages.size(); l++) {

                                    if ((GridPane.getRowIndex(blackimages.get(l)) == blackcastlerow && GridPane.getColumnIndex(blackimages.get(l)) == hdown + k) || (GridPane.getRowIndex(whiteimages.get(l)) == blackcastlerow && GridPane.getColumnIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7 && checkdown == 0) {
                                        //System.out.println("hassan");
                                        if (GridPane.getColumnIndex(whiteimages.get(l)) == hdown + k && GridPane.getRowIndex(whiteimages.get(l)) == blackcastlerow) {
                                            //  System.out.println("ahmad");
                                            borderGlow.setColor(Color.RED);
                                            r[blackcastlerow][hdown + k].setEffect(borderGlow);

                                            borderGlow.setColor(Color.BLUE);

                                        }

                                        checkdown++;
                                    }

                                }
                                if (checkdown == 0 && hdown + k <= 7) {
                                    //   System.out.println("faisal");
                                    r[blackcastlerow][hdown + k].setEffect(borderGlow);

                                }
                            }//checking condition

                            if (checkup != 0 && checkdown != 0) {
                                break;
                            }

                        }
                        //}
                        hup = root.getRowIndex(img1);
                        hdown = root.getRowIndex(img1);
                        //hup= to check up rows
                        //hdown=to check down rows
                        //  if(j==column){
                        checkup1 = 0;
                        checkdown1 = 0;

                        for (int k = 1; k < r.length; k++) {
                            // System.out.println("hassan");
                            if ((hup - k) >= 0 || hdown + k <= 7) {
                                //    System.out.println("ahmad");
                                for (int q = 0; q < blackimages.size(); q++) {
                                    //      System.out.println("faraz");
                                    if ((GridPane.getColumnIndex(blackimages.get(q)) == blackcastle1column && GridPane.getRowIndex(blackimages.get(q)) == hup - k) || (GridPane.getColumnIndex(whiteimages.get(q)) == blackcastle1column && GridPane.getRowIndex(whiteimages.get(q)) == hup - k) && hup - k >= 0 && checkup1 == 0) // if(GridPane.getColumnIndex(whiteimages.get(q))==column&&GridPane.getRowIndex(whiteimages.get(q))==hup-k&&hup-k>=0&&checkup==0&&GridPane.getColumnIndex(blackimages.get(q))!=GridPane.getColumnIndex(blackimages)//&&blackimages.get(q)!=img) 
                                    {
                                        //        System.out.println("talha");
                                        if (GridPane.getRowIndex(whiteimages.get(q)) == hup - k && GridPane.getColumnIndex(whiteimages.get(q)) == blackcastle1column) {
                                            //          System.out.println("fazool");
                                            borderGlow.setColor(Color.RED);
                                            r[hup - k][blackcastle1column].setEffect(borderGlow);

                                            borderGlow.setColor(Color.BLUE);

                                        }
                                        checkup1++;
                                    }
                                }
                                if (checkup1 == 0 && hup - k >= 0) {
                                    r[hup - k][blackcastle1column].setEffect(borderGlow);

                                }

                                for (int l = 0; l < blackimages.size(); l++) {
                                    if ((GridPane.getColumnIndex(blackimages.get(l)) == blackcastle1column && GridPane.getRowIndex(blackimages.get(l)) == hdown + k) || (GridPane.getColumnIndex(whiteimages.get(l)) == blackcastle1column && GridPane.getRowIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7 && checkdown1 == 0) {
                                        if (GridPane.getRowIndex(whiteimages.get(l)) == hdown + k && GridPane.getColumnIndex(whiteimages.get(l)) == blackcastle1column) {
                                            borderGlow.setColor(Color.RED);
                                            r[hdown + k][blackcastle1column].setEffect(borderGlow);

                                            borderGlow.setColor(Color.BLUE);

                                        } else {
                                        }
                                        checkdown1++;
                                    }

                                }
                                if (checkdown1 == 0 && hdown + k <= 7) {
                                    r[hdown + k][blackcastle1column].setEffect(borderGlow);

                                }
                            }//checking condition

                            if (checkup1 != 0 && checkdown1 != 0 && checkup != 0 && checkdown != 0) {
                                break;
                            }

                        }
                    }
                }
            }
        });
 imwhitequeen.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (imwhitequeen.isPressed()) {
                    if (opposite.equals("white")) {
                        clear();
                        name = "whitequeen";
                        checkup = 0;
                        checkdown = 0;
                        checkup1 = 0;
                        checkdown1 = 0;

                        int hup = root.getColumnIndex(imwhitequeen);
                        int hdown = root.getColumnIndex(imwhitequeen);

                        for (int k = 1; k < r.length; k++) {
                            //    for (int t = 0; t < whiteimages.size(); t++) {
                            if ((hup - k) >= 0 || hdown + k <= 7) {
                                //    System.out.println("ahmad");
                                for (int q = 0; q < blackimages.size(); q++) {
                                    //      System.out.println("faraz");
                                    if (hup - k >= 0 && ((GridPane.getRowIndex(whiteimages.get(q)) == rowwhitequeen && GridPane.getColumnIndex(whiteimages.get(q)) == hup - k)) || ((GridPane.getRowIndex(blackimages.get(q)) == rowwhitequeen && GridPane.getColumnIndex(blackimages.get(q)) == hup - k))&&checkup == 0  ) {
                                        if (GridPane.getColumnIndex(blackimages.get(q)) == hup - k && GridPane.getRowIndex(blackimages.get(q)) == rowwhitequeen) {
                                            borderGlow.setColor(Color.RED);
                                            r[rowwhitequeen][hup - k].setEffect(borderGlow);

                                            borderGlow.setColor(Color.BLUE);

                                        }
                                        checkup++;
                                    }
                                }
                                if (checkup == 0 && hup - k >= 0) {
                                 
                                    r[rowwhitequeen][hup - k].setEffect(borderGlow);

                                }

                                for (int l = 0; l < whiteimages.size(); l++) {

                                    if (  hdown + k <= 7&&(GridPane.getRowIndex(whiteimages.get(l)) == rowwhitequeen && GridPane.getColumnIndex(whiteimages.get(l)) == hdown + k) || (GridPane.getRowIndex(blackimages.get(l)) == rowwhitequeen && GridPane.getColumnIndex(blackimages.get(l)) == hdown + k)&&checkdown == 0  ) {
                                        if (GridPane.getColumnIndex(blackimages.get(l)) == hdown + k && GridPane.getRowIndex(blackimages.get(l)) == rowwhitequeen) {
                                            borderGlow.setColor(Color.RED);
                                            r[rowwhitequeen][hdown + k].setEffect(borderGlow);

                                            borderGlow.setColor(Color.BLUE);

                                        }

                                        checkdown++;
                                    }

                                }
                                if (checkdown == 0 && hdown + k <= 7) {
                                    r[rowwhitequeen][hdown + k].setEffect(borderGlow);

                                }
                            }//checking condition

                            if (checkup != 0 && checkdown != 0) {
                                break;
                            }

                        }
                        //}
                        hup = root.getRowIndex(imwhitequeen);
                        hdown = root.getRowIndex(imwhitequeen);
                        checkup = 0;
                        checkdown = 0;

                        for (int k = 1; k < r.length; k++) {
                            if ((hup - k) >= 0 || hdown + k <= 7) {
                                for (int q = 0; q < whiteimages.size(); q++) {
                                    if ( hup - k >= 0 &&(GridPane.getColumnIndex(whiteimages.get(q)) == columnwhitequeen && GridPane.getRowIndex(whiteimages.get(q)) == hup - k) || (GridPane.getColumnIndex(blackimages.get(q)) == columnwhitequeen && GridPane.getRowIndex(blackimages.get(q)) == hup - k)&& checkup == 0 ) {
                                        if (GridPane.getRowIndex(blackimages.get(q)) == hup - k && GridPane.getColumnIndex(blackimages.get(q)) == columnwhitequeen) {
                                            borderGlow.setColor(Color.RED);
                                            r[hup - k][columnwhitequeen].setEffect(borderGlow);

                                            borderGlow.setColor(Color.BLUE);

                                        }
                                        checkup++;
                                    }
                                }
                                if (checkup == 0 && hup - k >= 0) {
                                    r[hup - k][columnwhitequeen].setEffect(borderGlow);

                                }

                                for (int l = 0; l < whiteimages.size(); l++) {
                                    if ( hdown + k <= 7&&(GridPane.getColumnIndex(whiteimages.get(l)) == columnwhitequeen && GridPane.getRowIndex(whiteimages.get(l)) == hdown + k) || (GridPane.getColumnIndex(blackimages.get(l)) == columnwhitequeen && GridPane.getRowIndex(blackimages.get(l)) == hdown + k)&&checkdown == 0   ) {
                                        if (GridPane.getRowIndex(blackimages.get(l)) == hdown + k && GridPane.getColumnIndex(blackimages.get(l)) == columnwhitequeen) {
                                            borderGlow.setColor(Color.RED);
                                            r[hdown + k][columnwhitequeen].setEffect(borderGlow);

                                            borderGlow.setColor(Color.BLUE);

                                        }
                                        checkdown++;
                                    }

                                }
                                if (checkdown == 0 && hdown + k <= 7) {
                                    r[hdown + k][columnwhitequeen].setEffect(borderGlow);

                                }
                            }//checking condition
                        }
                        hup = root.getColumnIndex(imwhitequeen);
                        hdown = root.getColumnIndex(imwhitequeen);
                        checkup = 0;
                        checkdown = 0;
                        checkup1 = 0;
                        checkdown1 = 0;

                        for (int k = 1; k < r.length; k++) {
                            //    for (int t = 0; t < whiteimages.size(); t++) {
                            if ((hup - k) >= 0 || hdown + k <= 7) {
                                //    System.out.println("ahmad");
                                for (int q = 0; q < whiteimages.size(); q++) {
                                    //      System.out.println("faraz");
                                    if (rowwhitequeen - k >= 0 && (GridPane.getRowIndex(whiteimages.get(q)) == rowwhitequeen - k && GridPane.getColumnIndex(whiteimages.get(q)) == hup - k) || (GridPane.getRowIndex(blackimages.get(q)) == rowwhitequeen - k && GridPane.getColumnIndex(blackimages.get(q)) == hup - k) && hup - k >= 0 && checkup == 0) // if(GridPane.getColumnIndex(whiteimages.get(q))==column&&GridPane.getRowIndex(whiteimages.get(q))==hup-k&&hup-k>=0&&checkup==0&&GridPane.getColumnIndex(whiteimages.get(q))!=GridPane.getColumnIndex(whiteimages)//&&whiteimages.get(q)!=img) 
                                    {
                                        //        System.out.println("talha");
                                        if (GridPane.getColumnIndex(blackimages.get(q)) == hup - k && GridPane.getRowIndex(blackimages.get(q)) == rowwhitequeen - k) {
                                            //          System.out.println("fazool");
                                            borderGlow.setColor(Color.RED);
                                            r[rowwhitequeen - k][hup - k].setEffect(borderGlow);

                                            borderGlow.setColor(Color.BLUE);

                                        }
                                        checkup++;
                                    }
                                }
                                if (checkup == 0 && hup - k >= 0 && rowwhitequeen - k >= 0) {
                                    //System.out.println("huziafa");
                                    r[rowwhitequeen - k][hup - k].setEffect(borderGlow);

                                }

                                for (int l = 0; l < whiteimages.size(); l++) {

                                    //System.out.println("owais");
                                    if (rowwhitequeen - k >= 0 && hdown + k <= 7  &&(GridPane.getRowIndex(whiteimages.get(l)) == rowwhitequeen - k && GridPane.getColumnIndex(whiteimages.get(l)) == hdown + k) || (GridPane.getRowIndex(blackimages.get(l)) == rowwhitequeen - k && GridPane.getColumnIndex(blackimages.get(l)) == hdown + k)&& checkdown == 0 ) {
                                        // System.out.println("sufiyan");
                                        if (GridPane.getColumnIndex(blackimages.get(l)) == hdown + k && GridPane.getRowIndex(blackimages.get(l)) == rowwhitequeen - k) {
                                            borderGlow.setColor(Color.RED);
                                            r[rowwhitequeen - k][hdown + k].setEffect(borderGlow);

                                            borderGlow.setColor(Color.BLUE);

                                        }

                                        checkdown++;
                                    }

                                }
                                if (checkdown == 0 && hdown + k <= 7 && rowwhitequeen - k >= 0) {
                                    // System.out.println("fizan");
                                    r[rowwhitequeen - k][hdown + k].setEffect(borderGlow);

                                }

                                for (int q = 0; q < whiteimages.size(); q++) {
                                    //      System.out.println("faraz");
                                    if (rowwhitequeen + k <= 7 && hup - k >= 0 && (GridPane.getRowIndex(whiteimages.get(q)) == rowwhitequeen + k && GridPane.getColumnIndex(whiteimages.get(q)) == hup - k) || (GridPane.getRowIndex(blackimages.get(q)) == rowwhitequeen + k && GridPane.getColumnIndex(blackimages.get(q)) == hup - k)&& checkup1 == 0 ) // if(GridPane.getColumnIndex(whiteimages.get(q))==column&&GridPane.getRowIndex(whiteimages.get(q))==hup-k&&hup-k>=0&&checkup==0&&GridPane.getColumnIndex(whiteimages.get(q))!=GridPane.getColumnIndex(whiteimages)//&&whiteimages.get(q)!=img) 
                                    {
                                        //        System.out.println("talha");
                                        if (GridPane.getColumnIndex(blackimages.get(q)) == hup - k && GridPane.getRowIndex(blackimages.get(q)) == rowwhitequeen + k) {
                                            //          System.out.println("fazool");
                                            borderGlow.setColor(Color.RED);
                                            r[rowwhitequeen + k][hup - k].setEffect(borderGlow);

                                            borderGlow.setColor(Color.BLUE);

                                        }
                                        checkup1++;
                                    }
                                }
                                if (checkup1 == 0 && hup - k >= 0 && rowwhitequeen + k <= 7) {
                                    //System.out.println("huziafa");
                                    r[rowwhitequeen + k][hup - k].setEffect(borderGlow);

                                }

                                for (int l = 0; l < whiteimages.size(); l++) {

                                    //System.out.println("owais");
                                    if (rowwhitequeen + k <= 7 && (GridPane.getRowIndex(whiteimages.get(l)) == rowwhitequeen + k && GridPane.getColumnIndex(whiteimages.get(l)) == hdown + k) || (GridPane.getRowIndex(blackimages.get(l)) == rowwhitequeen + k && GridPane.getColumnIndex(blackimages.get(l)) == hdown + k) && hdown + k <= 7&& checkdown1 == 0 ) {
                                        // System.out.println("sufiyan");
                                        if (GridPane.getColumnIndex(blackimages.get(l)) == hdown + k && GridPane.getRowIndex(blackimages.get(l)) == rowwhitequeen + k) {
                                            borderGlow.setColor(Color.RED);
                                            r[rowwhitequeen + k][hdown + k].setEffect(borderGlow);

                                            borderGlow.setColor(Color.BLUE);

                                        }

                                        checkdown1++;
                                    }

                                }
                                if (checkdown1 == 0 && hdown + k <= 7 && rowwhitequeen + k <= 7) {
                                    // System.out.println("fizan");
                                    r[rowwhitequeen + k][hdown + k].setEffect(borderGlow);

                                }

                            }
                            if (checkup != 0 && checkdown != 0 && checkup1 != 0 && checkdown1 != 0) {
                                break;
                            }
                        }

                    }
                }
            }
        });
        imblackking.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (imblackking.isPressed()) {
                    if (opposite.equals("black")) {
                        clear();
                        name = "blackking";
                        checkup = 0;
                        checkdown = 0;
                        checkup1 = 0;
                        checkdown1 = 0;

                        int hup = root.getColumnIndex(imblackking);
                        int hdown = root.getColumnIndex(imblackking);

                        for (int k = 1; k <= 1; k++) {
                            //    for (int t = 0; t < blackimages.size(); t++) {
                            if ((hup - k) >= 0 || hdown + k <= 7) {
                                //    System.out.println("ahmad");
                                if (checkfirst(root.getRowIndex(imblackking), blackkingrow, blackkingcolumn - 1, -1) == true || (checkwhitecastle(root.getRowIndex(imblackking), root.getColumnIndex(imblackking) - 1) == true) || (checkwhitepawn(root.getRowIndex(imblackking), root.getColumnIndex(imblackking) - 1)) || (checkwhitebishops(root.getRowIndex(imblackking), root.getColumnIndex(imblackking) - 1)) || (checkwhitequeen(root.getRowIndex(imblackking), root.getColumnIndex(imblackking) - 1))) {
                                    checkup++;
                                }
                                for (int q = 0; q < blackimages.size(); q++) {
                                    //      System.out.println("faraz");
                                    if ((GridPane.getRowIndex(blackimages.get(q)) == blackkingrow && GridPane.getColumnIndex(blackimages.get(q)) == hup - k) || (GridPane.getRowIndex(whiteimages.get(q)) == blackkingrow && GridPane.getColumnIndex(whiteimages.get(q)) == hup - k) && hup - k >= 0 && checkup == 0) {
                                        if (GridPane.getColumnIndex(whiteimages.get(q)) == hup - k && GridPane.getRowIndex(whiteimages.get(q)) == blackkingrow) {
                                            borderGlow.setColor(Color.RED);
                                            r[blackkingrow][hup - k].setEffect(borderGlow);

                                            borderGlow.setColor(Color.BLUE);

                                        }
                                        checkup++;
                                    }
                                }
                                if (checkup == 0 && hup - k >= 0) {
                                    r[blackkingrow][hup - k].setEffect(borderGlow);

                                }

                                if (checkfirst(root.getRowIndex(imblackking), blackkingrow, blackkingcolumn + 1, +1) == true || (checkwhitecastle(root.getRowIndex(imblackking), root.getColumnIndex(imblackking) + 1) == true) || (checkwhitepawn(root.getRowIndex(imblackking), root.getColumnIndex(imblackking) + 1)) || (checkwhitebishops(root.getRowIndex(imblackking), root.getColumnIndex(imblackking) + 1)) || (checkwhitequeen(root.getRowIndex(imblackking), root.getColumnIndex(imblackking) + 1))) {
                                    checkdown++;
                                }

                                for (int l = 0; l < blackimages.size(); l++) {

                                    if (checkdown == 0 && (GridPane.getRowIndex(blackimages.get(l)) == blackkingrow && GridPane.getColumnIndex(blackimages.get(l)) == hdown + k) || (GridPane.getRowIndex(whiteimages.get(l)) == blackkingrow && GridPane.getColumnIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7) {
                                        if (GridPane.getColumnIndex(whiteimages.get(l)) == hdown + k && GridPane.getRowIndex(whiteimages.get(l)) == blackkingrow) {
                                            borderGlow.setColor(Color.RED);
                                            r[blackkingrow][hdown + k].setEffect(borderGlow);

                                            borderGlow.setColor(Color.BLUE);

                                        }

                                        checkdown++;
                                    }

                                }
                                if (checkdown == 0 && hdown + k <= 7) {
                                    r[blackkingrow][hdown + k].setEffect(borderGlow);

                                }
                            }//checking condition

                        }
                        //}
                        hup = root.getRowIndex(imblackking);
                        hdown = root.getRowIndex(imblackking);
                        checkup = 0;
                        checkdown = 0;
                        if (checkfirst(root.getRowIndex(imblackking) - 1, blackkingrow, blackkingcolumn, 0) == true || (checkwhitecastle(root.getRowIndex(imblackking) - 1, root.getColumnIndex(imblackking)) == true) || (checkwhitepawn(root.getRowIndex(imblackking) - 1, root.getColumnIndex(imblackking))) || (checkwhitebishops(root.getRowIndex(imblackking) - 1, root.getColumnIndex(imblackking))) || (checkwhitequeen(root.getRowIndex(imblackking) - 1, root.getColumnIndex(imblackking)))) {
                            checkup++;
                        }

                        for (int k = 1; k <= 1; k++) {
                            if ((hup - k) >= 0 || hdown + k <= 7) {
                                for (int q = 0; q < blackimages.size(); q++) {
                                    if ((GridPane.getColumnIndex(blackimages.get(q)) == blackkingcolumn && GridPane.getRowIndex(blackimages.get(q)) == hup - k) || (GridPane.getColumnIndex(whiteimages.get(q)) == blackkingcolumn && GridPane.getRowIndex(whiteimages.get(q)) == hup - k) && hup - k >= 0 && checkup == 0) {
                                        if (GridPane.getRowIndex(whiteimages.get(q)) == hup - k && GridPane.getColumnIndex(whiteimages.get(q)) == blackkingcolumn) {
                                            borderGlow.setColor(Color.RED);
                                            r[hup - k][blackkingcolumn].setEffect(borderGlow);

                                            borderGlow.setColor(Color.BLUE);

                                        }
                                        checkup++;
                                    }
                                }
                                if (checkup == 0 && hup - k >= 0) {
                                    r[hup - k][blackkingcolumn].setEffect(borderGlow);

                                }
                                if (checkfirst(root.getRowIndex(imblackking) + 1, blackkingrow, blackkingcolumn, 0) == true || (checkwhitecastle(root.getRowIndex(imblackking) + 1, root.getColumnIndex(imblackking)) == true) || (checkwhitepawn(root.getRowIndex(imblackking) + 1, root.getColumnIndex(imblackking))) || (checkwhitebishops(root.getRowIndex(imblackking) + 1, root.getColumnIndex(imblackking))) || (checkwhitequeen(root.getRowIndex(imblackking) + 1, root.getColumnIndex(imblackking)))) {
                                    checkdown++;
                                }
//                                   
                                for (int l = 0; l < blackimages.size(); l++) {
                                    if (checkdown == 0 && (GridPane.getColumnIndex(blackimages.get(l)) == blackkingcolumn && GridPane.getRowIndex(blackimages.get(l)) == hdown + k) || (GridPane.getColumnIndex(whiteimages.get(l)) == blackkingcolumn && GridPane.getRowIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7) {
                                        if (GridPane.getRowIndex(whiteimages.get(l)) == hdown + k && GridPane.getColumnIndex(whiteimages.get(l)) == blackkingcolumn) {
                                            borderGlow.setColor(Color.RED);
                                            r[hdown + k][blackkingcolumn].setEffect(borderGlow);

                                            borderGlow.setColor(Color.BLUE);

                                        } else {
                                        }
                                        checkdown++;
                                    }

                                }
                                if (checkdown == 0 && hdown + k <= 7) {
                                    r[hdown + k][blackkingcolumn].setEffect(borderGlow);

                                }
                            }//checking condition
                        }
                        hup = root.getColumnIndex(imblackking);
                        hdown = root.getColumnIndex(imblackking);
                        checkup = 0;
                        checkdown = 0;
                        checkup1 = 0;
                        checkdown1 = 0;
                        if (checkfirst(root.getRowIndex(imblackking) - 1, blackkingrow, blackkingcolumn - 1, -1) == true || (checkwhitecastle(root.getRowIndex(imblackking) - 1, root.getColumnIndex(imblackking) - 1) == true) || (checkwhitepawn(root.getRowIndex(imblackking) - 1, root.getColumnIndex(imblackking) - 1)) || (checkwhitebishops(root.getRowIndex(imblackking) - 1, root.getColumnIndex(imblackking) - 1)) || (checkwhitequeen(root.getRowIndex(imblackking) - 1, root.getColumnIndex(imblackking) - 1))) {
                            System.out.println("zimbagta");
                            checkup++;
                        }
                        for (int k = 1; k <= 1; k++) {
                            //    for (int t = 0; t < blackimages.size(); t++) {
                            if ((hup - k) >= 0 || hdown + k <= 7) {
                                //    System.out.println("ahmad");
                                for (int q = 0; q < blackimages.size(); q++) {
                                    //      System.out.println("faraz");
                                    if (blackkingrow - k >= 0 && (GridPane.getRowIndex(blackimages.get(q)) == blackkingrow - k && GridPane.getColumnIndex(blackimages.get(q)) == hup - k) || (GridPane.getRowIndex(whiteimages.get(q)) == blackkingrow - k && GridPane.getColumnIndex(whiteimages.get(q)) == hup - k) && hup - k >= 0 && checkup == 0) // if(GridPane.getColumnIndex(whiteimages.get(q))==column&&GridPane.getRowIndex(whiteimages.get(q))==hup-k&&hup-k>=0&&checkup==0&&GridPane.getColumnIndex(blackimages.get(q))!=GridPane.getColumnIndex(blackimages)//&&blackimages.get(q)!=img) 
                                    {
                                        if(checkup==0)
                                        {
                                        //        System.out.println("talha");
                                        if (GridPane.getColumnIndex(whiteimages.get(q)) == hup - k && GridPane.getRowIndex(whiteimages.get(q)) == blackkingrow - k) {
                                            //          System.out.println("fazool");
                                            borderGlow.setColor(Color.RED);
                                            r[blackkingrow - k][hup - k].setEffect(borderGlow);

                                            borderGlow.setColor(Color.BLUE);

                                        }
                                        checkup++;
                                    }
                                    }
                                }
                                if (checkup == 0 && hup - k >= 0 && blackkingrow - k >= 0) {
                                    //System.out.println("huziafa");
                                    r[blackkingrow - k][hup - k].setEffect(borderGlow);

                                }
                                if (checkfirst(root.getRowIndex(imblackking) - 1, blackkingrow, blackkingcolumn + 1, +1) == true || (checkwhitecastle(root.getRowIndex(imblackking) - 1, root.getColumnIndex(imblackking) + 1) == true) || (checkwhitepawn(root.getRowIndex(imblackking) - 1, root.getColumnIndex(imblackking) + 1)) || (checkwhitebishops(root.getRowIndex(imblackking) - 1, root.getColumnIndex(imblackking) + 1)) || (checkwhitequeen(root.getRowIndex(imblackking) - 1, root.getColumnIndex(imblackking) + 1))) {
                                    checkdown++;
                                }
                                for (int l = 0; l < blackimages.size(); l++) {

                                    //System.out.println("owais");
                                    if (blackkingrow - k >= 0 && (GridPane.getRowIndex(blackimages.get(l)) == blackkingrow - k && GridPane.getColumnIndex(blackimages.get(l)) == hdown + k) || (GridPane.getRowIndex(whiteimages.get(l)) == blackkingrow - k && GridPane.getColumnIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7 && checkdown == 0) {
                                        // System.out.println("sufiyan");
                                     if(checkdown==0)
                                     {
                                        if (GridPane.getColumnIndex(whiteimages.get(l)) == hdown + k && GridPane.getRowIndex(whiteimages.get(l)) == blackkingrow - k) {
                                            borderGlow.setColor(Color.RED);
                                            r[blackkingrow - k][hdown + k].setEffect(borderGlow);

                                            borderGlow.setColor(Color.BLUE);

                                        }

                                        checkdown++;
                                    }
                                    }
                                }
                                if (checkdown == 0 && hdown + k <= 7 && blackkingrow - k >= 0) {
                                    // System.out.println("fizan");
                                    r[blackkingrow - k][hdown + k].setEffect(borderGlow);

                                }
                                if (checkfirst(root.getRowIndex(imblackking) + 1, blackkingrow, blackkingcolumn - 1, -1) == true || (checkwhitecastle(root.getRowIndex(imblackking) + 1, root.getColumnIndex(imblackking) - 1) == true) || (checkwhitepawn(root.getRowIndex(imblackking) + 1, root.getColumnIndex(imblackking) - 1)) || (checkwhitebishops(root.getRowIndex(imblackking) + 1, root.getColumnIndex(imblackking) - 1)) || (checkwhitequeen(root.getRowIndex(imblackking) + 1, root.getColumnIndex(imblackking) - 1))) {
                                    checkup1++;
                                }

                                for (int q = 0; q < blackimages.size(); q++) {
                                    //      System.out.println("faraz");
                                    if (blackkingrow + k <= 7 && (GridPane.getRowIndex(blackimages.get(q)) == blackkingrow + k && GridPane.getColumnIndex(blackimages.get(q)) == hup - k) || (GridPane.getRowIndex(whiteimages.get(q)) == blackkingrow + k && GridPane.getColumnIndex(whiteimages.get(q)) == hup - k) && hup - k >= 0 && checkup1 == 0) // if(GridPane.getColumnIndex(whiteimages.get(q))==column&&GridPane.getRowIndex(whiteimages.get(q))==hup-k&&hup-k>=0&&checkup==0&&GridPane.getColumnIndex(blackimages.get(q))!=GridPane.getColumnIndex(blackimages)//&&blackimages.get(q)!=img) 
                                    {
                                        if(checkup1==0)
                                        {
                                        //        System.out.println("talha");
                                        if (GridPane.getColumnIndex(whiteimages.get(q)) == hup - k && GridPane.getRowIndex(whiteimages.get(q)) == blackkingrow + k) {
                                            //          System.out.println("fazool");
                                            borderGlow.setColor(Color.RED);
                                            r[blackkingrow + k][hup - k].setEffect(borderGlow);

                                            borderGlow.setColor(Color.BLUE);

                                        }
                                        checkup1++;
                                    }
                                }
                                }
                                if (checkup1 == 0 && hup - k >= 0 && blackkingrow + k <= 7) {
                                    //System.out.println("huziafa");
                                    r[blackkingrow + k][hup - k].setEffect(borderGlow);

                                }
//                                    if( checkfirst(hup+1,root.getRowIndex(imblackking)+1,blackkingrow,blackkingcolumn)==true)
                                if (checkfirst(root.getRowIndex(imblackking) + 1, blackkingrow, blackkingcolumn + 1, +1) == true || (checkwhitecastle(root.getRowIndex(imblackking) + 1, root.getColumnIndex(imblackking) + 1) == true) || (checkwhitepawn(root.getRowIndex(imblackking) + 1, root.getColumnIndex(imblackking) + 1)) || (checkwhitebishops(root.getRowIndex(imblackking) + 1, root.getColumnIndex(imblackking) + 1)) || (checkwhitequeen(root.getRowIndex(imblackking) + 1, root.getColumnIndex(imblackking) + 1))) {
                                    checkdown1++;
                                }
                                for (int l = 0; l < blackimages.size(); l++) {

                                    //System.out.println("owais");
                                    if (blackkingrow + k <= 7 && checkdown1 == 0 && (GridPane.getRowIndex(blackimages.get(l)) == blackkingrow + k && GridPane.getColumnIndex(blackimages.get(l)) == hdown + k) || (GridPane.getRowIndex(whiteimages.get(l)) == blackkingrow + k && GridPane.getColumnIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7) {
                                        // System.out.println("sufiyan");
                                 if(checkdown1==0)
                                 {
                                        if (GridPane.getColumnIndex(whiteimages.get(l)) == hdown + k && GridPane.getRowIndex(whiteimages.get(l)) == blackkingrow + k) {
                                            borderGlow.setColor(Color.RED);
                                            r[blackkingrow + k][hdown + k].setEffect(borderGlow);

                                            borderGlow.setColor(Color.BLUE);

                                        }

                                        checkdown1++;
                                    }
                                    }
                                }
                                if (checkdown1 == 0 && hdown + k <= 7 && blackkingrow + k <= 7) {
                                    // System.out.println("fizan");
                                    r[blackkingrow + k][hdown + k].setEffect(borderGlow);

                                }

                            }
                            if (checkup != 0 && checkdown != 0 && checkup1 != 0 && checkdown1 != 0) {
                                break;
                            }
                        }

                    }
                }
            }
        });

        imblackbishop1.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (imblackbishop1.isPressed()) {
                    if (opposite.equals("black")) {
                        name = "blackbishop1";
                        clear();
                        for (int i = 0; i < r.length; i++) {
                            for (int j = 0; j < r[i].length; j++) {
                                if (j == blackbishoprow1) {
                                    checkup = 0;
                                    checkdown = 0;
                                    checkup1 = 0;
                                    checkdown1 = 0;
                                    int hup = root.getColumnIndex(imblackbishop1);
                                    int hdown = root.getColumnIndex(imblackbishop1);

                                    for (int k = 1; k < r[i].length; k++) {
                                        //    for (int t = 0; t < blackimages.size(); t++) {
                                        if ((hup - k) >= 0 || hdown + k <= 7) {
                                            //    System.out.println("ahmad");
                                            for (int q = 0; q < blackimages.size(); q++) {
                                                //      System.out.println("faraz");
                                                if (blackbishoprow1 - k >= 0 && (GridPane.getRowIndex(blackimages.get(q)) == blackbishoprow1 - k && GridPane.getColumnIndex(blackimages.get(q)) == hup - k) || (GridPane.getRowIndex(whiteimages.get(q)) == blackbishoprow1 - k && GridPane.getColumnIndex(whiteimages.get(q)) == hup - k) && hup - k >= 0 && checkup == 0) // if(GridPane.getColumnIndex(whiteimages.get(q))==column&&GridPane.getRowIndex(whiteimages.get(q))==hup-k&&hup-k>=0&&checkup==0&&GridPane.getColumnIndex(blackimages.get(q))!=GridPane.getColumnIndex(blackimages)//&&blackimages.get(q)!=img) 
                                                {
                                                    //        System.out.println("talha");
                                                    if (GridPane.getColumnIndex(whiteimages.get(q)) == hup - k && GridPane.getRowIndex(whiteimages.get(q)) == blackbishoprow1 - k) {
                                                        //          System.out.println("fazool");
                                                        borderGlow.setColor(Color.RED);
                                                        r[blackbishoprow1 - k][hup - k].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }
                                                    checkup++;
                                                }
                                            }
                                            if (checkup == 0 && hup - k >= 0 && blackbishoprow1 - k >= 0) {
                                                //System.out.println("huziafa");
                                                r[blackbishoprow1 - k][hup - k].setEffect(borderGlow);

                                            }

                                            for (int l = 0; l < blackimages.size(); l++) {

                                                //System.out.println("owais");
                                                if (blackbishoprow1 - k >= 0 && (GridPane.getRowIndex(blackimages.get(l)) == blackbishoprow1 - k && GridPane.getColumnIndex(blackimages.get(l)) == hdown + k) || (GridPane.getRowIndex(whiteimages.get(l)) == blackbishoprow1 - k && GridPane.getColumnIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7 && checkdown == 0) {
                                                    // System.out.println("sufiyan");
                                                    if (GridPane.getColumnIndex(whiteimages.get(l)) == hdown + k && GridPane.getRowIndex(whiteimages.get(l)) == blackbishoprow1 - k) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[blackbishoprow1 - k][hdown + k].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }

                                                    checkdown++;
                                                }

                                            }
                                            if (checkdown == 0 && hdown + k <= 7 && blackbishoprow1 - k >= 0) {
                                                // System.out.println("fizan");
                                                r[blackbishoprow1 - k][hdown + k].setEffect(borderGlow);

                                            }

                                            for (int q = 0; q < blackimages.size(); q++) {
                                                //      System.out.println("faraz");
                                                if (blackbishoprow1 + k <= 7 && (GridPane.getRowIndex(blackimages.get(q)) == blackbishoprow1 + k && GridPane.getColumnIndex(blackimages.get(q)) == hup - k) || (GridPane.getRowIndex(whiteimages.get(q)) == blackbishoprow1 + k && GridPane.getColumnIndex(whiteimages.get(q)) == hup - k) && hup - k >= 0 && checkup1 == 0) // if(GridPane.getColumnIndex(whiteimages.get(q))==column&&GridPane.getRowIndex(whiteimages.get(q))==hup-k&&hup-k>=0&&checkup==0&&GridPane.getColumnIndex(blackimages.get(q))!=GridPane.getColumnIndex(blackimages)//&&blackimages.get(q)!=img) 
                                                {
                                                    //        System.out.println("talha");
                                                    if (GridPane.getColumnIndex(whiteimages.get(q)) == hup - k && GridPane.getRowIndex(whiteimages.get(q)) == blackbishoprow1 + k) {
                                                        //          System.out.println("fazool");
                                                        borderGlow.setColor(Color.RED);
                                                        r[blackbishoprow1 + k][hup - k].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }
                                                    checkup1++;
                                                }
                                            }
                                            if (checkup1 == 0 && hup - k >= 0 && blackbishoprow1 + k <= 7) {
                                                //System.out.println("huziafa");
                                                r[blackbishoprow1 + k][hup - k].setEffect(borderGlow);

                                            }

                                            for (int l = 0; l < blackimages.size(); l++) {

                                                //System.out.println("owais");
                                                if (blackbishoprow1 + k <= 7 && checkdown1 == 0 && (GridPane.getRowIndex(blackimages.get(l)) == blackbishoprow1 + k && GridPane.getColumnIndex(blackimages.get(l)) == hdown + k) || (GridPane.getRowIndex(whiteimages.get(l)) == blackbishoprow1 + k && GridPane.getColumnIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7) {
                                                    // System.out.println("sufiyan");
                                                    if (GridPane.getColumnIndex(whiteimages.get(l)) == hdown + k && GridPane.getRowIndex(whiteimages.get(l)) == blackbishoprow1 + k) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[blackbishoprow1 + k][hdown + k].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }

                                                    checkdown1++;
                                                }

                                            }
                                            if (checkdown1 == 0 && hdown + k <= 7 && blackbishoprow1 + k <= 7) {
                                                // System.out.println("fizan");
                                                r[blackbishoprow1 + k][hdown + k].setEffect(borderGlow);

                                            }

                                        }
                                        if (checkup != 0 && checkdown != 0 && checkup1 != 0 && checkdown1 != 0) {
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });

        imblackqueen.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (imblackqueen.isPressed()) {
                    if (opposite.equals("black")) {
                        clear();
                        name = "blackqueen";
                        checkup = 0;
                        checkdown = 0;
                        checkup1 = 0;
                        checkdown1 = 0;

                        int hup = root.getColumnIndex(imblackqueen);
                        int hdown = root.getColumnIndex(imblackqueen);

                        for (int k = 1; k < r.length; k++) {
                            //    for (int t = 0; t < blackimages.size(); t++) {
                            if ((hup - k) >= 0 || hdown + k <= 7) {
                                //    System.out.println("ahmad");
                                for (int q = 0; q < blackimages.size(); q++) {
                                    //      System.out.println("faraz");
                                    if ((GridPane.getRowIndex(blackimages.get(q)) == blackqueenrow && GridPane.getColumnIndex(blackimages.get(q)) == hup - k) || (GridPane.getRowIndex(whiteimages.get(q)) == blackqueenrow && GridPane.getColumnIndex(whiteimages.get(q)) == hup - k) && hup - k >= 0 && checkup == 0) {
                                        if (GridPane.getColumnIndex(whiteimages.get(q)) == hup - k && GridPane.getRowIndex(whiteimages.get(q)) == blackqueenrow) {
                                            borderGlow.setColor(Color.RED);
                                            r[blackqueenrow][hup - k].setEffect(borderGlow);

                                            borderGlow.setColor(Color.BLUE);

                                        }
                                        checkup++;
                                    }
                                }
                                if (checkup == 0 && hup - k >= 0) {
                                    r[blackqueenrow][hup - k].setEffect(borderGlow);

                                }

                                for (int l = 0; l < blackimages.size(); l++) {

                                    if ( (GridPane.getRowIndex(blackimages.get(l)) == blackqueenrow && GridPane.getColumnIndex(blackimages.get(l)) == hdown + k) || (GridPane.getRowIndex(whiteimages.get(l)) == blackqueenrow && GridPane.getColumnIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7&&checkdown == 0 ) {
                                        if (GridPane.getColumnIndex(whiteimages.get(l)) == hdown + k && GridPane.getRowIndex(whiteimages.get(l)) == blackqueenrow) {
                                            borderGlow.setColor(Color.RED);
                                            r[blackqueenrow][hdown + k].setEffect(borderGlow);

                                            borderGlow.setColor(Color.BLUE);

                                        }

                                        checkdown++;
                                    }

                                }
                                if (checkdown == 0 && hdown + k <= 7) {
                                    r[blackqueenrow][hdown + k].setEffect(borderGlow);

                                }
                            }//checking condition

                            if (checkup != 0 && checkdown != 0) {
                                break;
                            }

                        }
                        //}
                        hup = root.getRowIndex(imblackqueen);
                        hdown = root.getRowIndex(imblackqueen);
                        checkup = 0;
                        checkdown = 0;

                        for (int k = 1; k < r.length; k++) {
                            if ((hup - k) >= 0 || hdown + k <= 7) {
                                for (int q = 0; q < blackimages.size(); q++) {
                                    if ((GridPane.getColumnIndex(blackimages.get(q)) == blackqueencolumn && GridPane.getRowIndex(blackimages.get(q)) == hup - k) || (GridPane.getColumnIndex(whiteimages.get(q)) == blackqueencolumn && GridPane.getRowIndex(whiteimages.get(q)) == hup - k) && hup - k >= 0 && checkup == 0) {
                                        if (GridPane.getRowIndex(whiteimages.get(q)) == hup - k && GridPane.getColumnIndex(whiteimages.get(q)) == blackqueencolumn) {
                                            borderGlow.setColor(Color.RED);
                                            r[hup - k][blackqueencolumn].setEffect(borderGlow);

                                            borderGlow.setColor(Color.BLUE);

                                        }
                                        checkup++;
                                    }
                                }
                                if (checkup == 0 && hup - k >= 0) {
                                    r[hup - k][blackqueencolumn].setEffect(borderGlow);

                                }

                                for (int l = 0; l < blackimages.size(); l++) {
                                    if ( (GridPane.getColumnIndex(blackimages.get(l)) == blackqueencolumn && GridPane.getRowIndex(blackimages.get(l)) == hdown + k) || (GridPane.getColumnIndex(whiteimages.get(l)) == blackqueencolumn && GridPane.getRowIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7&&checkdown == 0 ) {
                                        if (GridPane.getRowIndex(whiteimages.get(l)) == hdown + k && GridPane.getColumnIndex(whiteimages.get(l)) == blackqueencolumn) {
                                            borderGlow.setColor(Color.RED);
                                            r[hdown + k][blackqueencolumn].setEffect(borderGlow);

                                            borderGlow.setColor(Color.BLUE);

                                        } else {
                                        }
                                        checkdown++;
                                    }

                                }
                                if (checkdown == 0 && hdown + k <= 7) {
                                    r[hdown + k][blackqueencolumn].setEffect(borderGlow);

                                }
                            }//checking condition
                        }
                        hup = root.getColumnIndex(imblackqueen);
                        hdown = root.getColumnIndex(imblackqueen);
                        checkup = 0;
                        checkdown = 0;
                        checkup1 = 0;
                        checkdown1 = 0;

                        for (int k = 1; k < r.length; k++) {
                            //    for (int t = 0; t < blackimages.size(); t++) {
                            if ((hup - k) >= 0 || hdown + k <= 7) {
                                //    System.out.println("ahmad");
                                for (int q = 0; q < blackimages.size(); q++) {
                                    //      System.out.println("faraz");
                                    if (blackqueenrow - k >= 0 && (GridPane.getRowIndex(blackimages.get(q)) == blackqueenrow - k && GridPane.getColumnIndex(blackimages.get(q)) == hup - k) || (GridPane.getRowIndex(whiteimages.get(q)) == blackqueenrow - k && GridPane.getColumnIndex(whiteimages.get(q)) == hup - k) && hup - k >= 0 && checkup == 0) // if(GridPane.getColumnIndex(whiteimages.get(q))==column&&GridPane.getRowIndex(whiteimages.get(q))==hup-k&&hup-k>=0&&checkup==0&&GridPane.getColumnIndex(blackimages.get(q))!=GridPane.getColumnIndex(blackimages)//&&blackimages.get(q)!=img) 
                                    {
                                        //        System.out.println("talha");
                                        if (GridPane.getColumnIndex(whiteimages.get(q)) == hup - k && GridPane.getRowIndex(whiteimages.get(q)) == blackqueenrow - k) {
                                            //          System.out.println("fazool");
                                            borderGlow.setColor(Color.RED);
                                            r[blackqueenrow - k][hup - k].setEffect(borderGlow);

                                            borderGlow.setColor(Color.BLUE);

                                        }
                                        checkup++;
                                    }
                                }
                                if (checkup == 0 && hup - k >= 0 && blackqueenrow - k >= 0) {
                                    //System.out.println("huziafa");
                                    r[blackqueenrow - k][hup - k].setEffect(borderGlow);

                                }

                                for (int l = 0; l < blackimages.size(); l++) {

                                    //System.out.println("owais");
                                    if (blackqueenrow - k >= 0 && (GridPane.getRowIndex(blackimages.get(l)) == blackqueenrow - k && GridPane.getColumnIndex(blackimages.get(l)) == hdown + k) || (GridPane.getRowIndex(whiteimages.get(l)) == blackqueenrow - k && GridPane.getColumnIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7 && checkdown == 0) {
                                        // System.out.println("sufiyan");
                                        if (GridPane.getColumnIndex(whiteimages.get(l)) == hdown + k && GridPane.getRowIndex(whiteimages.get(l)) == blackqueenrow - k) {
                                            borderGlow.setColor(Color.RED);
                                            r[blackqueenrow - k][hdown + k].setEffect(borderGlow);

                                            borderGlow.setColor(Color.BLUE);

                                        }

                                        checkdown++;
                                    }

                                }
                                if (checkdown == 0 && hdown + k <= 7 && blackqueenrow - k >= 0) {
                                    // System.out.println("fizan");
                                    r[blackqueenrow - k][hdown + k].setEffect(borderGlow);

                                }

                                for (int q = 0; q < blackimages.size(); q++) {
                                    //      System.out.println("faraz");
                                    if (blackqueenrow + k <= 7 && (GridPane.getRowIndex(blackimages.get(q)) == blackqueenrow + k && GridPane.getColumnIndex(blackimages.get(q)) == hup - k) || (GridPane.getRowIndex(whiteimages.get(q)) == blackqueenrow + k && GridPane.getColumnIndex(whiteimages.get(q)) == hup - k) && hup - k >= 0 && checkup1 == 0) // if(GridPane.getColumnIndex(whiteimages.get(q))==column&&GridPane.getRowIndex(whiteimages.get(q))==hup-k&&hup-k>=0&&checkup==0&&GridPane.getColumnIndex(blackimages.get(q))!=GridPane.getColumnIndex(blackimages)//&&blackimages.get(q)!=img) 
                                    {
                                        //        System.out.println("talha");
                                        if (GridPane.getColumnIndex(whiteimages.get(q)) == hup - k && GridPane.getRowIndex(whiteimages.get(q)) == blackqueenrow + k) {
                                            //          System.out.println("fazool");
                                            borderGlow.setColor(Color.RED);
                                            r[blackqueenrow + k][hup - k].setEffect(borderGlow);

                                            borderGlow.setColor(Color.BLUE);

                                        }
                                        checkup1++;
                                    }
                                }
                                if (checkup1 == 0 && hup - k >= 0 && blackqueenrow + k <= 7) {
                                    //System.out.println("huziafa");
                                    r[blackqueenrow + k][hup - k].setEffect(borderGlow);

                                }

                                for (int l = 0; l < blackimages.size(); l++) {

                                    //System.out.println("owais");
                                    if (blackqueenrow + k <= 7  && (GridPane.getRowIndex(blackimages.get(l)) == blackqueenrow + k && GridPane.getColumnIndex(blackimages.get(l)) == hdown + k) || (GridPane.getRowIndex(whiteimages.get(l)) == blackqueenrow + k && GridPane.getColumnIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7&& checkdown1 == 0) {
                                        // System.out.println("sufiyan");
                                        if (GridPane.getColumnIndex(whiteimages.get(l)) == hdown + k && GridPane.getRowIndex(whiteimages.get(l)) == blackqueenrow + k) {
                                            borderGlow.setColor(Color.RED);
                                            r[blackqueenrow + k][hdown + k].setEffect(borderGlow);

                                            borderGlow.setColor(Color.BLUE);

                                        }

                                        checkdown1++;
                                    }

                                }
                                if (checkdown1 == 0 && hdown + k <= 7 && blackqueenrow + k <= 7) {
                                    // System.out.println("fizan");
                                    r[blackqueenrow + k][hdown + k].setEffect(borderGlow);

                                }

                            }
                            if (checkup != 0 && checkdown != 0 && checkup1 != 0 && checkdown1 != 0) {
                                break;
                            }
                        }

                    }
                }
            }
        });
        
        imblackbishop.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (imblackbishop.isPressed()) {
                    if (opposite.equals("black")) {
                        name = "blackbishop";
                        clear();
                        for (int i = 0; i < r.length; i++) {
                            for (int j = 0; j < r[i].length; j++) {
                                if (j == blackbishoprow) {
                                    checkup = 0;
                                    checkdown = 0;
                                    checkup1 = 0;
                                    checkdown1 = 0;
                                    int hup = root.getColumnIndex(imblackbishop);
                                    int hdown = root.getColumnIndex(imblackbishop);

                                    for (int k = 1; k < r[i].length; k++) {
                                        //    for (int t = 0; t < blackimages.size(); t++) {
                                        if ((hup - k) >= 0 || hdown + k <= 7) {
                                            //    System.out.println("ahmad");
                                            for (int q = 0; q < blackimages.size(); q++) {
                                                //      System.out.println("faraz");
                                                if (blackbishoprow - k >= 0 && (GridPane.getRowIndex(blackimages.get(q)) == blackbishoprow - k && GridPane.getColumnIndex(blackimages.get(q)) == hup - k) || (GridPane.getRowIndex(whiteimages.get(q)) == blackbishoprow - k && GridPane.getColumnIndex(whiteimages.get(q)) == hup - k) && hup - k >= 0 && checkup == 0) // if(GridPane.getColumnIndex(whiteimages.get(q))==column&&GridPane.getRowIndex(whiteimages.get(q))==hup-k&&hup-k>=0&&checkup==0&&GridPane.getColumnIndex(blackimages.get(q))!=GridPane.getColumnIndex(blackimages)//&&blackimages.get(q)!=img) 
                                                {
                                                    //        System.out.println("talha");
                                                    if (GridPane.getColumnIndex(whiteimages.get(q)) == hup - k && GridPane.getRowIndex(whiteimages.get(q)) == blackbishoprow - k) {
                                                        //          System.out.println("fazool");
                                                        borderGlow.setColor(Color.RED);
                                                        r[blackbishoprow - k][hup - k].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }
                                                    checkup++;
                                                }
                                            }
                                            if (checkup == 0 && hup - k >= 0 && blackbishoprow - k >= 0) {
                                                //System.out.println("huziafa");
                                                r[blackbishoprow - k][hup - k].setEffect(borderGlow);

                                            }

                                            for (int l = 0; l < blackimages.size(); l++) {

                                                //System.out.println("owais");
                                                if (blackbishoprow - k >= 0 && (GridPane.getRowIndex(blackimages.get(l)) == blackbishoprow - k && GridPane.getColumnIndex(blackimages.get(l)) == hdown + k) || (GridPane.getRowIndex(whiteimages.get(l)) == blackbishoprow - k && GridPane.getColumnIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7 && checkdown == 0) {
                                                    //   System.out.println("sufiyan");
                                                    if (GridPane.getColumnIndex(whiteimages.get(l)) == hdown + k && GridPane.getRowIndex(whiteimages.get(l)) == blackbishoprow - k && checkdown == 0) {
                                                        // System.out.println("hassan");
                                                        borderGlow.setColor(Color.RED);
                                                        r[blackbishoprow - k][hdown + k].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }

                                                    checkdown++;
                                                }

                                            }
                                            if (checkdown == 0 && hdown + k <= 7 && blackbishoprow - k >= 0) {
                                                //System.out.println("fizan");
                                                r[blackbishoprow - k][hdown + k].setEffect(borderGlow);

                                            }

                                            for (int q = 0; q < blackimages.size(); q++) {
                                                //      System.out.println("faraz");
                                                if (blackbishoprow + k <= 7 && (GridPane.getRowIndex(blackimages.get(q)) == blackbishoprow + k && GridPane.getColumnIndex(blackimages.get(q)) == hup - k) || (GridPane.getRowIndex(whiteimages.get(q)) == blackbishoprow + k && GridPane.getColumnIndex(whiteimages.get(q)) == hup - k) && hup - k >= 0 && checkup1 == 0) // if(GridPane.getColumnIndex(whiteimages.get(q))==column&&GridPane.getRowIndex(whiteimages.get(q))==hup-k&&hup-k>=0&&checkup==0&&GridPane.getColumnIndex(blackimages.get(q))!=GridPane.getColumnIndex(blackimages)//&&blackimages.get(q)!=img) 
                                                {
                                                    //     System.out.println("talha");
                                                    if (GridPane.getColumnIndex(whiteimages.get(q)) == hup - k && GridPane.getRowIndex(whiteimages.get(q)) == blackbishoprow + k) {
                                                        //  System.out.println("fazool");
                                                        borderGlow.setColor(Color.RED);
                                                        r[blackbishoprow + k][hup - k].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }
                                                    checkup1++;
                                                }
                                            }
                                            if (checkup1 == 0 && hup - k >= 0 && blackbishoprow + k <= 7) {
                                                //System.out.println("huziafa");
                                                r[blackbishoprow + k][hup - k].setEffect(borderGlow);

                                            }

                                            for (int l = 0; l < blackimages.size(); l++) {

                                                //System.out.println("owais");
                                                if (blackbishoprow + k <= 7 && checkdown1 == 0 && (GridPane.getRowIndex(blackimages.get(l)) == blackbishoprow + k && GridPane.getColumnIndex(blackimages.get(l)) == hdown + k) || (GridPane.getRowIndex(whiteimages.get(l)) == blackbishoprow + k && GridPane.getColumnIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7) {
                                                    // System.out.println("sufiyan");
                                                    if (GridPane.getColumnIndex(whiteimages.get(l)) == hdown + k && GridPane.getRowIndex(whiteimages.get(l)) == blackbishoprow + k) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[blackbishoprow + k][hdown + k].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }

                                                    checkdown1++;
                                                }

                                            }
                                            if (checkdown1 == 0 && hdown + k <= 7 && blackbishoprow + k <= 7) {
                                                // System.out.println("fizan");
                                                r[blackbishoprow + k][hdown + k].setEffect(borderGlow);

                                            }

                                        }
                                        if (checkup != 0 && checkdown != 0 && checkup1 != 0 && checkdown1 != 0) {
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });

///////////////////////
        imblackpiece.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (imblackpiece.isPressed()) {
                    if (opposite.equals("black")) {
                        name = "blackpawn1";
                        clear();
                        for (int i = 0; i < r.length; i++) {

                            for (int j = 0; j < r[i].length; j++) {
                                int hdown = root.getRowIndex(imblackpiece);
                                if (j == columnblackpiece) {
                                    checkup = 0;
                                    checkup1 = 0;
                                    checkdown = 0;
                                    int p;
                                    if (hdown == 6) {
                                        p = 2;
                                    } else {
                                        p = 1;
                                    }
                                    for (int k = 1; k <= p; k++) {
                                        // System.out.println("hassan");
                                        if (hdown - k >= 0) {
                                            //    System.out.println("ahmad");
                                            for (int q = 0; q < blackimages.size(); q++) {
                                                //      System.out.println("faraz");
                                                if ((GridPane.getColumnIndex(blackimages.get(q)) == columnblackpiece - 1 && GridPane.getRowIndex(blackimages.get(q)) == hdown - k) || (GridPane.getColumnIndex(whiteimages.get(q)) == columnblackpiece - 1 && GridPane.getRowIndex(whiteimages.get(q)) == hdown - k) && hdown - k >= 0 && checkup == 0 && k == 1) // if(GridPane.getColumnIndex(whiteimages.get(q))==column&&GridPane.getRowIndex(whiteimages.get(q))==hup-k&&hup-k>=0&&checkup==0&&GridPane.getColumnIndex(blackimages.get(q))!=GridPane.getColumnIndex(blackimages)//&&blackimages.get(q)!=img) 
                                                {
                                                    //        System.out.println("talha");
                                                    if (GridPane.getRowIndex(whiteimages.get(q)) == hdown - k && GridPane.getColumnIndex(blackimages.get(q)) == columnwhitepiece - 1) {
                                                        //          System.out.println("fazool");
                                                        borderGlow.setColor(Color.RED);
                                                        r[hdown - k][columnblackpiece - 1].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }
                                                    checkup++;
                                                }
                                            }
//                                   
                                            for (int l = 0; l < blackimages.size(); l++) {

                                                if ((GridPane.getColumnIndex(blackimages.get(l)) == columnblackpiece + 1 && GridPane.getRowIndex(blackimages.get(l)) == hdown - k) || (GridPane.getColumnIndex(whiteimages.get(l)) == columnblackpiece + 1 && GridPane.getRowIndex(whiteimages.get(l)) == hdown - k) && hdown + k >= 0 && k == 1 && checkdown == 0) {
                                                    if (GridPane.getRowIndex(whiteimages.get(l)) == hdown - k && GridPane.getColumnIndex(whiteimages.get(l)) == columnblackpiece + 1) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[hdown - k][columnblackpiece + 1].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    } else {
                                                    }
                                                    checkdown++;
                                                }

                                                for (int m = 0; m < blackimages.size(); m++) {

                                                    if ((GridPane.getColumnIndex(blackimages.get(m)) == columnblackpiece && GridPane.getRowIndex(blackimages.get(m)) == hdown - k) || (GridPane.getColumnIndex(whiteimages.get(m)) == columnblackpiece && GridPane.getRowIndex(whiteimages.get(m)) == hdown - k) && hdown - k >= 0) {
                                                        checkup1++;
                                                    }
                                                }
                                                if (checkup1 == 0 && hdown - k >= 0) {
                                                    // System.out.println("fizan");
                                                    r[hdown - k][columnblackpiece].setEffect(borderGlow);

                                                }
                                            }//checking condition

                                        }

                                    }

                                }

                            }
                        }
                    }
                }
            }
        });
        imblackpiece1.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (imblackpiece1.isPressed()) {
                    if (opposite.equals("black")) {
                        name = "blackpawn2";
                        clear();
                        for (int i = 0; i < r.length; i++) {

                            for (int j = 0; j < r[i].length; j++) {
                                int hdown = root.getRowIndex(imblackpiece1);
                                if (j == columnblackpiece1) {
                                    checkup = 0;
                                    checkup1 = 0;
                                    checkdown = 0;
                                    int p;
                                    if (hdown == 6) {
                                        p = 2;
                                    } else {
                                        p = 1;
                                    }
                                    for (int k = 1; k <= p; k++) {
                                        // System.out.println("hassan");
                                        if (hdown - k >= 0) {
                                            //    System.out.println("ahmad");
                                            for (int q = 0; q < blackimages.size(); q++) {
                                                //      System.out.println("faraz");
                                                if ((GridPane.getColumnIndex(blackimages.get(q)) == columnblackpiece1 - 1 && GridPane.getRowIndex(blackimages.get(q)) == hdown - k) || (GridPane.getColumnIndex(whiteimages.get(q)) == columnblackpiece1 - 1 && GridPane.getRowIndex(whiteimages.get(q)) == hdown - k) && hdown - k >= 0 && checkup == 0 && k == 1) // if(GridPane.getColumnIndex(whiteimages.get(q))==column&&GridPane.getRowIndex(whiteimages.get(q))==hup-k&&hup-k>=0&&checkup==0&&GridPane.getColumnIndex(blackimages.get(q))!=GridPane.getColumnIndex(blackimages)//&&blackimages.get(q)!=img) 
                                                {
                                                    //        System.out.println("talha");
                                                    if (GridPane.getRowIndex(whiteimages.get(q)) == hdown - k && GridPane.getColumnIndex(whiteimages.get(q)) == columnblackpiece1 - 1) {
                                                        //          System.out.println("fazool");
                                                        borderGlow.setColor(Color.RED);
                                                        r[hdown - k][columnblackpiece1 - 1].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }
                                                    checkup++;
                                                }
                                            }
//                                   if(checkup==0&&hup-k>=0)
//                                   {
//                                       //System.out.println("huziafa");
//                                         r[hup-k][column].setEffect(borderGlow);
//                                             
//                                   }
//                                   
                                            for (int l = 0; l < blackimages.size(); l++) {

                                                //System.out.println("owais");
                                                if ((GridPane.getColumnIndex(blackimages.get(l)) == columnblackpiece1 + 1 && GridPane.getRowIndex(blackimages.get(l)) == hdown - k) || (GridPane.getColumnIndex(whiteimages.get(l)) == columnblackpiece1 + 1 && GridPane.getRowIndex(whiteimages.get(l)) == hdown - k) && hdown - k >= 0 && k == 1 && checkdown == 0) {
                                                    // System.out.println("sufiyan");
                                                    if (GridPane.getRowIndex(whiteimages.get(l)) == hdown - k && GridPane.getColumnIndex(whiteimages.get(l)) == columnblackpiece1 + 1) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[hdown - k][columnblackpiece1 + 1].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    } else {
                                                    }
                                                    checkdown++;
                                                }

                                                for (int m = 0; m < blackimages.size(); m++) {

                                                    if ((GridPane.getColumnIndex(blackimages.get(m)) == columnblackpiece1 && GridPane.getRowIndex(blackimages.get(m)) == hdown - k) || (GridPane.getColumnIndex(whiteimages.get(m)) == columnblackpiece1 && GridPane.getRowIndex(whiteimages.get(m)) == hdown - k) && hdown - k >= 0) {
                                                        checkup1++;
                                                    }
                                                }
                                                if (checkup1 == 0 && hdown - k >= 0) {
                                                    // System.out.println("fizan");
                                                    r[hdown - k][columnblackpiece1].setEffect(borderGlow);

                                                }
                                            }//checking condition

                                        }

                                    }

                                }

                            }
                        }
                    }
                }
            }
        });

        imblackpiece2.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (imblackpiece2.isPressed()) {
                    name = "blackpawn3";
                    if (opposite.equals("black")) {
                        clear();
                        for (int i = 0; i < r.length; i++) {

                            for (int j = 0; j < r[i].length; j++) {
                                int hdown = root.getRowIndex(imblackpiece2);
                                if (j == columnblackpiece2) {
                                    checkup = 0;
                                    checkup1 = 0;
                                    checkdown = 0;
                                    int p;
                                    if (hdown == 6) {
                                        p = 2;
                                    } else {
                                        p = 1;
                                    }
                                    for (int k = 1; k <= p; k++) {
                                        // System.out.println("hassan");
                                        if (hdown - k >= 0) {
                                            //    System.out.println("ahmad");
                                            for (int q = 0; q < blackimages.size(); q++) {
                                                //      System.out.println("faraz");
                                                if ((GridPane.getColumnIndex(blackimages.get(q)) == columnblackpiece2 - 1 && GridPane.getRowIndex(blackimages.get(q)) == hdown - k) || (GridPane.getColumnIndex(whiteimages.get(q)) == columnblackpiece2 - 1 && GridPane.getRowIndex(whiteimages.get(q)) == hdown - k) && hdown - k <= 7 && checkup == 0 && k == 1) // if(GridPane.getColumnIndex(whiteimages.get(q))==column&&GridPane.getRowIndex(whiteimages.get(q))==hup-k&&hup-k>=0&&checkup==0&&GridPane.getColumnIndex(blackimages.get(q))!=GridPane.getColumnIndex(blackimages)//&&blackimages.get(q)!=img) 
                                                {
                                                    //        System.out.println("talha");
                                                    if (GridPane.getRowIndex(whiteimages.get(q)) == hdown - k && GridPane.getColumnIndex(whiteimages.get(q)) == columnblackpiece2 - 1) {
                                                        //          System.out.println("fazool");
                                                        borderGlow.setColor(Color.RED);
                                                        r[hdown - k][columnblackpiece2 - 1].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }
                                                    checkup++;
                                                }
                                            }
//                                   if(checkup==0&&hup-k>=0)
//                                   {
//                                       //System.out.println("huziafa");
//                                         r[hup-k][column].setEffect(borderGlow);
//                                             
//                                   }
//                                   
                                            for (int l = 0; l < blackimages.size(); l++) {

                                                //System.out.println("owais");
                                                if ((GridPane.getColumnIndex(blackimages.get(l)) == columnblackpiece2 + 1 && GridPane.getRowIndex(blackimages.get(l)) == hdown + k) || (GridPane.getColumnIndex(whiteimages.get(l)) == columnblackpiece2 + 1 && GridPane.getRowIndex(whiteimages.get(l)) == hdown - k) && hdown - k >= 0 && k == 1 && checkdown == 0) {
                                                    // System.out.println("sufiyan");
                                                    if (GridPane.getRowIndex(whiteimages.get(l)) == hdown - k && GridPane.getColumnIndex(whiteimages.get(l)) == columnblackpiece2 + 1) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[hdown - k][columnblackpiece2 + 1].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    } else {
                                                    }
                                                    checkdown++;
                                                }

                                                for (int m = 0; m < blackimages.size(); m++) {

                                                    if ((GridPane.getColumnIndex(blackimages.get(m)) == columnblackpiece2 && GridPane.getRowIndex(blackimages.get(m)) == hdown - k) || (GridPane.getColumnIndex(whiteimages.get(m)) == columnblackpiece2 && GridPane.getRowIndex(whiteimages.get(m)) == hdown - k) && hdown - k >= 0) {
                                                        checkup1++;
                                                    }
                                                }
                                                if (checkup1 == 0 && hdown - k >= 0) {
                                                    // System.out.println("fizan");
                                                    r[hdown - k][columnblackpiece2].setEffect(borderGlow);

                                                }
                                            }//checking condition

                                        }

                                    }

                                }
                            }
                        }
                    }
                }
            }

        });

        imblackpiece3.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (imblackpiece3.isPressed()) {
                    if (opposite.equals("black")) {
                        name = "blackpawn4";
                        clear();
                        for (int i = 0; i < r.length; i++) {

                            for (int j = 0; j < r[i].length; j++) {
                                int hdown = root.getRowIndex(imblackpiece3);
                                if (j == columnblackpiece3) {
                                    checkup = 0;
                                    checkdown = 0;
                                    checkup1 = 0;
                                    int p;
                                    if (hdown == 6) {
                                        p = 2;
                                    } else {
                                        p = 1;
                                    }
                                    for (int k = 1; k <= p; k++) {
                                        // System.out.println("hassan");
                                        if (hdown - k >= 0) {
                                            //    System.out.println("ahmad");
                                            for (int q = 0; q < blackimages.size(); q++) {
                                                //      System.out.println("faraz");
                                                if ((GridPane.getColumnIndex(blackimages.get(q)) == columnblackpiece3 - 1 && GridPane.getRowIndex(blackimages.get(q)) == hdown - k) || (GridPane.getColumnIndex(whiteimages.get(q)) == columnblackpiece3 - 1 && GridPane.getRowIndex(whiteimages.get(q)) == hdown - k) && hdown - k >= 0 && checkup == 0 && k == 1) // if(GridPane.getColumnIndex(whiteimages.get(q))==column&&GridPane.getRowIndex(whiteimages.get(q))==hup-k&&hup-k>=0&&checkup==0&&GridPane.getColumnIndex(blackimages.get(q))!=GridPane.getColumnIndex(blackimages)//&&blackimages.get(q)!=img) 
                                                {
                                                    //        System.out.println("talha");
                                                    if (GridPane.getRowIndex(whiteimages.get(q)) == hdown - k && GridPane.getColumnIndex(whiteimages.get(q)) == columnblackpiece3 - 1) {
                                                        //          System.out.println("fazool");
                                                        borderGlow.setColor(Color.RED);
                                                        r[hdown - k][columnblackpiece3 - 1].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }
                                                    checkup++;
                                                }
                                            }
//                                   
                                            for (int l = 0; l < blackimages.size(); l++) {

                                                if ((GridPane.getColumnIndex(blackimages.get(l)) == columnblackpiece3 + 1 && GridPane.getRowIndex(blackimages.get(l)) == hdown - k) || (GridPane.getColumnIndex(whiteimages.get(l)) == columnblackpiece3 + 1 && GridPane.getRowIndex(whiteimages.get(l)) == hdown - k) && hdown - k >= 0 && k == 1 && checkdown == 0) {
                                                    if (GridPane.getRowIndex(whiteimages.get(l)) == hdown - k && GridPane.getColumnIndex(whiteimages.get(l)) == columnblackpiece3 + 1) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[hdown - k][columnblackpiece3 + 1].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    } else {
                                                    }
                                                    checkdown++;
                                                }

                                                for (int m = 0; m < blackimages.size(); m++) {

                                                    if ((GridPane.getColumnIndex(blackimages.get(m)) == columnblackpiece3 && GridPane.getRowIndex(blackimages.get(m)) == hdown - k) || (GridPane.getColumnIndex(whiteimages.get(m)) == columnblackpiece3 && GridPane.getRowIndex(whiteimages.get(m)) == hdown - k) && hdown - k >= 0) {
                                                        checkup1++;
                                                    }
                                                }
                                                if (checkup1 == 0 && hdown - k >= 0) {
                                                    // System.out.println("fizan");
                                                    r[hdown - k][columnblackpiece3].setEffect(borderGlow);

                                                }
                                            }//checking condition

                                        }

                                    }

                                }

                            }
                        }
                    }
                }
            }
        });
        imblackpiece4.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (imblackpiece4.isPressed()) {
                    if (opposite.equals("black")) {
                        name = "blackpawn5";
                        clear();
                        for (int i = 0; i < r.length; i++) {

                            for (int j = 0; j < r[i].length; j++) {
                                int hdown = root.getRowIndex(imblackpiece4);
                                if (j == columnblackpiece4) {
                                    checkup = 0;
                                    checkup1 = 0;
                                    checkdown = 0;
                                    int p;
                                    if (hdown == 6) {
                                        p = 2;
                                    } else {
                                        p = 1;
                                    }
                                    for (int k = 1; k <= p; k++) {
                                        // System.out.println("hassan");
                                        if (hdown - k >= 0) {
                                            //    System.out.println("ahmad");
                                            for (int q = 0; q < blackimages.size(); q++) {
                                                //      System.out.println("faraz");
                                                if ((GridPane.getColumnIndex(blackimages.get(q)) == columnblackpiece4 - 1 && GridPane.getRowIndex(blackimages.get(q)) == hdown - k) || (GridPane.getColumnIndex(whiteimages.get(q)) == columnblackpiece4 - 1 && GridPane.getRowIndex(whiteimages.get(q)) == hdown - k) && hdown - k >= 0 && checkup == 0 && k == 1) // if(GridPane.getColumnIndex(whiteimages.get(q))==column&&GridPane.getRowIndex(whiteimages.get(q))==hup-k&&hup-k>=0&&checkup==0&&GridPane.getColumnIndex(blackimages.get(q))!=GridPane.getColumnIndex(blackimages)//&&blackimages.get(q)!=img) 
                                                {
                                                    //        System.out.println("talha");
                                                    if (GridPane.getRowIndex(whiteimages.get(q)) == hdown - k && GridPane.getColumnIndex(whiteimages.get(q)) == columnblackpiece4 - 1) {
                                                        //          System.out.println("fazool");
                                                        borderGlow.setColor(Color.RED);
                                                        r[hdown - k][columnblackpiece4 - 1].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }
                                                    checkup++;
                                                }
                                            }
//                                   
                                            for (int l = 0; l < blackimages.size(); l++) {

                                                if ((GridPane.getColumnIndex(blackimages.get(l)) == columnblackpiece4 + 1 && GridPane.getRowIndex(blackimages.get(l)) == hdown - k) || (GridPane.getColumnIndex(whiteimages.get(l)) == columnblackpiece4 + 1 && GridPane.getRowIndex(whiteimages.get(l)) == hdown - k) && hdown - k >= 0 && k == 1 && checkdown == 0) {
                                                    if (GridPane.getRowIndex(whiteimages.get(l)) == hdown - k && GridPane.getColumnIndex(whiteimages.get(l)) == columnblackpiece4 + 1) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[hdown - k][columnblackpiece4 + 1].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    } else {
                                                    }
                                                    checkdown++;
                                                }

                                                for (int m = 0; m < blackimages.size(); m++) {

                                                    if ((GridPane.getColumnIndex(blackimages.get(m)) == columnblackpiece4 && GridPane.getRowIndex(blackimages.get(m)) == hdown - k) || (GridPane.getColumnIndex(whiteimages.get(m)) == columnblackpiece4 && GridPane.getRowIndex(whiteimages.get(m)) == hdown - k) && hdown - k >= 0) {
                                                        checkup1++;
                                                    }
                                                }
                                                if (checkup1 == 0 && hdown - k >= 0) {
                                                    // System.out.println("fizan");
                                                    r[hdown - k][columnblackpiece4].setEffect(borderGlow);

                                                }
                                            }//checking condition

                                        }

                                    }

                                }
                            }

                        }
                    }
                }
            }

        });
        imblackpiece5.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (imblackpiece5.isPressed()) {
                    if (opposite.equals("black")) {
                        name = "blackpawn6";
                        clear();
                        for (int i = 0; i < r.length; i++) {

                            for (int j = 0; j < r[i].length; j++) {
                                int hdown = root.getRowIndex(imblackpiece5);
                                if (j == columnblackpiece5) {
                                    checkup = 0;
                                    checkup1 = 0;
                                    checkdown = 0;
                                    int p;
                                    if (hdown == 6) {
                                        p = 2;
                                    } else {
                                        p = 1;
                                    }
                                    for (int k = 1; k <= p; k++) {
                                        // System.out.println("hassan");
                                        if (hdown - k >= 0) {
                                            //    System.out.println("ahmad");
                                            for (int q = 0; q < blackimages.size(); q++) {
                                                //      System.out.println("faraz");
                                                if ((GridPane.getColumnIndex(blackimages.get(q)) == columnblackpiece5 - 1 && GridPane.getRowIndex(blackimages.get(q)) == hdown - k) || (GridPane.getColumnIndex(whiteimages.get(q)) == columnblackpiece5 - 1 && GridPane.getRowIndex(whiteimages.get(q)) == hdown - k) && hdown - k >= 0 && checkup == 0 && k == 1) // if(GridPane.getColumnIndex(whiteimages.get(q))==column&&GridPane.getRowIndex(whiteimages.get(q))==hup-k&&hup-k>=0&&checkup==0&&GridPane.getColumnIndex(blackimages.get(q))!=GridPane.getColumnIndex(blackimages)//&&blackimages.get(q)!=img) 
                                                {
                                                    //        System.out.println("talha");
                                                    if (GridPane.getRowIndex(whiteimages.get(q)) == hdown - k && GridPane.getColumnIndex(whiteimages.get(q)) == columnblackpiece5 - 1) {
                                                        //          System.out.println("fazool");
                                                        borderGlow.setColor(Color.RED);
                                                        r[hdown - k][columnblackpiece5 - 1].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }
                                                    checkup++;
                                                }
                                            }
//                                   
                                            for (int l = 0; l < blackimages.size(); l++) {

                                                if ((GridPane.getColumnIndex(blackimages.get(l)) == columnblackpiece5 + 1 && GridPane.getRowIndex(blackimages.get(l)) == hdown - k) || (GridPane.getColumnIndex(whiteimages.get(l)) == columnblackpiece5 + 1 && GridPane.getRowIndex(whiteimages.get(l)) == hdown - k) && hdown - k >= 0 && k == 1 && checkdown == 0) {
                                                    if (GridPane.getRowIndex(whiteimages.get(l)) == hdown - k && GridPane.getColumnIndex(whiteimages.get(l)) == columnblackpiece5 + 1) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[hdown - k][columnblackpiece5 + 1].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    } else {
                                                    }
                                                    checkdown++;
                                                }

                                                for (int m = 0; m < blackimages.size(); m++) {

                                                    if ((GridPane.getColumnIndex(blackimages.get(m)) == columnblackpiece5 && GridPane.getRowIndex(blackimages.get(m)) == hdown - k) || (GridPane.getColumnIndex(whiteimages.get(m)) == columnblackpiece5 && GridPane.getRowIndex(whiteimages.get(m)) == hdown - k) && hdown - k >= 0) {
                                                        checkup1++;
                                                    }
                                                }
                                                if (checkup1 == 0 && hdown - k >= 0) {
                                                    // System.out.println("fizan");
                                                    r[hdown - k][columnblackpiece5].setEffect(borderGlow);

                                                }
                                            }//checking condition

                                        }

                                    }

                                }

                            }
                        }
                    }
                }
            }
        });
        imblackpiece6.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (imblackpiece6.isPressed()) {
                    if (opposite.equals("black")) {
                        name = "blackpawn7";
                        clear();
                        for (int i = 0; i < r.length; i++) {

                            for (int j = 0; j < r[i].length; j++) {
                                int hdown = root.getRowIndex(imblackpiece6);
                                if (j == columnblackpiece6) {
                                    checkup = 0;
                                    checkup1 = 0;
                                    checkdown = 0;
                                    int p;
                                    if (hdown == 6) {
                                        p = 2;
                                    } else {
                                        p = 1;
                                    }
                                    for (int k = 1; k <= p; k++) {
                                        // System.out.println("hassan");
                                        if (hdown - k >= 0) {
                                            //    System.out.println("ahmad");
                                            for (int q = 0; q < blackimages.size(); q++) {
                                                //      System.out.println("faraz");
                                                if ((GridPane.getColumnIndex(blackimages.get(q)) == columnblackpiece6 - 1 && GridPane.getRowIndex(blackimages.get(q)) == hdown - k) || (GridPane.getColumnIndex(whiteimages.get(q)) == columnblackpiece6 - 1 && GridPane.getRowIndex(whiteimages.get(q)) == hdown - k) && hdown - k >= 0 && checkup == 0 && k == 1) // if(GridPane.getColumnIndex(whiteimages.get(q))==column&&GridPane.getRowIndex(whiteimages.get(q))==hup-k&&hup-k>=0&&checkup==0&&GridPane.getColumnIndex(blackimages.get(q))!=GridPane.getColumnIndex(blackimages)//&&blackimages.get(q)!=img) 
                                                {
                                                    //        System.out.println("talha");
                                                    if (GridPane.getRowIndex(whiteimages.get(q)) == hdown - k && GridPane.getColumnIndex(whiteimages.get(q)) == columnblackpiece6 - 1) {
                                                        //          System.out.println("fazool");
                                                        borderGlow.setColor(Color.RED);
                                                        r[hdown - k][columnblackpiece6 - 1].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }
                                                    checkup++;
                                                }
                                            }
//                                   
                                            for (int l = 0; l < blackimages.size(); l++) {

                                                if ((GridPane.getColumnIndex(blackimages.get(l)) == columnblackpiece6 + 1 && GridPane.getRowIndex(blackimages.get(l)) == hdown - k) || (GridPane.getColumnIndex(whiteimages.get(l)) == columnblackpiece6 + 1 && GridPane.getRowIndex(whiteimages.get(l)) == hdown - k) && hdown - k >= 0 && k == 1 && checkdown == 0) {
                                                    if (GridPane.getRowIndex(whiteimages.get(l)) == hdown - k && GridPane.getColumnIndex(whiteimages.get(l)) == columnblackpiece6 + 1) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[hdown - k][columnblackpiece6 + 1].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    } else {
                                                    }
                                                    checkdown++;
                                                }

                                                for (int m = 0; m < blackimages.size(); m++) {

                                                    if ((GridPane.getColumnIndex(blackimages.get(m)) == columnblackpiece6 && GridPane.getRowIndex(blackimages.get(m)) == hdown - k) || (GridPane.getColumnIndex(whiteimages.get(m)) == columnblackpiece6 && GridPane.getRowIndex(whiteimages.get(m)) == hdown - k) && hdown - k >= 0) {
                                                        checkup1++;
                                                    }
                                                }
                                                if (checkup1 == 0 && hdown - k >= 0) {
                                                    // System.out.println("fizan");
                                                    r[hdown - k][columnblackpiece6].setEffect(borderGlow);

                                                }
                                            }//checking condition

                                        }

                                    }

                                }

                            }
                        }
                    }
                }
            }
        });
        imblackpiece7.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (imblackpiece7.isPressed()) {
                    if (opposite.equals("black")) {
                        name = "blackpawn8";
                        clear();
                        for (int i = 0; i < r.length; i++) {

                            for (int j = 0; j < r[i].length; j++) {
                                int hdown = root.getRowIndex(imblackpiece7);
                                if (j == columnblackpiece7) {
                                    checkup = 0;
                                    checkup1 = 0;
                                    checkdown = 0;
                                    int p;
                                    if (hdown == 6) {
                                        p = 2;
                                    } else {
                                        p = 1;
                                    }
                                    for (int k = 1; k <= p; k++) {
                                        // System.out.println("hassan");
                                        if (hdown - k >= 0) {
                                            //    System.out.println("ahmad");
                                            for (int q = 0; q < blackimages.size(); q++) {
                                                //      System.out.println("faraz");
                                                if ((GridPane.getColumnIndex(blackimages.get(q)) == columnblackpiece7 - 1 && GridPane.getRowIndex(blackimages.get(q)) == hdown - k) || (GridPane.getColumnIndex(whiteimages.get(q)) == columnblackpiece7 - 1 && GridPane.getRowIndex(whiteimages.get(q)) == hdown - k) && hdown - k >= 0 && checkup == 0 && k == 1) // if(GridPane.getColumnIndex(whiteimages.get(q))==column&&GridPane.getRowIndex(whiteimages.get(q))==hup-k&&hup-k>=0&&checkup==0&&GridPane.getColumnIndex(blackimages.get(q))!=GridPane.getColumnIndex(blackimages)//&&blackimages.get(q)!=img) 
                                                {
                                                    //        System.out.println("talha");
                                                    if (GridPane.getRowIndex(whiteimages.get(q)) == hdown - k && GridPane.getColumnIndex(whiteimages.get(q)) == columnblackpiece7 - 1) {
                                                        //          System.out.println("fazool");
                                                        borderGlow.setColor(Color.RED);
                                                        r[hdown - k][columnblackpiece7 - 1].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }
                                                    checkup++;
                                                }
                                            }
//                                   if(checkup==0&&hup-k>=0)
//                                   {
//                                       //System.out.println("huziafa");
//                                         r[hup-k][column].setEffect(borderGlow);
//                                             
//                                   }
//                                   
                                            for (int l = 0; l < blackimages.size(); l++) {

                                                //System.out.println("owais");
                                                if ((GridPane.getColumnIndex(blackimages.get(l)) == columnblackpiece7 + 1 && GridPane.getRowIndex(blackimages.get(l)) == hdown - k) || (GridPane.getColumnIndex(whiteimages.get(l)) == columnblackpiece7 + 1 && GridPane.getRowIndex(whiteimages.get(l)) == hdown - k) && hdown - k >= 0 && k == 1 && checkdown == 0) {
                                                    // System.out.println("sufiyan");
                                                    if (GridPane.getRowIndex(whiteimages.get(l)) == hdown - k && GridPane.getColumnIndex(whiteimages.get(l)) == columnblackpiece7 + 1) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[hdown - k][columnblackpiece7 + 1].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    } else {
                                                    }
                                                    checkdown++;
                                                }

                                                for (int m = 0; m < blackimages.size(); m++) {

                                                    if ((GridPane.getColumnIndex(blackimages.get(m)) == columnblackpiece7 && GridPane.getRowIndex(blackimages.get(m)) == hdown - k) || (GridPane.getColumnIndex(whiteimages.get(m)) == columnblackpiece7 && GridPane.getRowIndex(whiteimages.get(m)) == hdown - k) && hdown - k >= 0) {
                                                        checkup1++;
                                                    }
                                                }
                                                if (checkup1 == 0 && hdown - k >= 0) {
                                                    // System.out.println("fizan");
                                                    r[hdown - k][columnblackpiece7].setEffect(borderGlow);

                                                }
                                            }//checking condition

                                        }

                                    }

                                }

                            }
                        }
                    }
                }
            }
        });
        img.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                if (img.isPressed()) {
                    if (opposite.equals("black")) {
                        name = "blackcastle";
                        clear();

//                                if(event.getButton()==MouseButton.PRIMARY){
//                for (int i = 0; i < ra.length; i++) {
//                    for (int j = 0; j < ra[i].length; j++) {
//                       //r[i][j].setEffect(10);
//                      // Rectangle cr=ra.get(i);
//                      if(ra[i][j].isPressed() &&  ra[i][j].getEffect()!=10){
////                       if(ra[i][j].contains(event.getX()-35,event.getY()-35)){
//System.out.println(ra[i][j].getFill());
//          for (int k = 0; k < ra.length; k++) {
//                              for (int l = 0; l < ra[i].length; l++) {
//                                  ra[k][l].setEffect(10);
//                              }
//                          }
////
////    if(r[1][0].getEffect()!=10){
////r[1][0].setEffect(10);
////    }
//       
//                      }
//                       
//                        
//                        //}
//                    }
//                    }
//                }
                        //for (int i = 0; i < r.length; i++) {
                        //for (int j = 0; j < r[i].length; j++) {
                        // if(i==row){
                        checkup = 0;
                        checkdown = 0;
                        checkup1 = 0;
                        checkdown1 = 0;
                        int hup = root.getColumnIndex(img);
                        int hdown = root.getColumnIndex(img);

                        for (int k = 1; k < r.length; k++) {
                            //    for (int t = 0; t < blackimages.size(); t++) {
                            if ((hup - k) >= 0 || hdown + k <= 7) {
                                //    System.out.println("ahmad");
                                for (int q = 0; q < blackimages.size(); q++) {
                                    //      System.out.println("faraz");
                                    if ((GridPane.getRowIndex(blackimages.get(q)) == row && GridPane.getColumnIndex(blackimages.get(q)) == hup - k) || (GridPane.getRowIndex(whiteimages.get(q)) == row && GridPane.getColumnIndex(whiteimages.get(q)) == hup - k) && hup - k >= 0 && checkup == 0) {
                                        if (GridPane.getColumnIndex(whiteimages.get(q)) == hup - k && GridPane.getRowIndex(whiteimages.get(q)) == row) {
                                            borderGlow.setColor(Color.RED);
                                            r[row][hup - k].setEffect(borderGlow);

                                            borderGlow.setColor(Color.BLUE);

                                        }
                                        checkup++;
                                    }
                                }
                                if (checkup == 0 && hup - k >= 0) {
                                    r[row][hup - k].setEffect(borderGlow);

                                }

                                for (int l = 0; l < blackimages.size(); l++) {

                                    if ((GridPane.getRowIndex(blackimages.get(l)) == row && GridPane.getColumnIndex(blackimages.get(l)) == hdown + k) || (GridPane.getRowIndex(whiteimages.get(l)) == row && GridPane.getColumnIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7 && checkdown == 0) {
                                        //System.out.println("hassan");
                                        if (GridPane.getColumnIndex(whiteimages.get(l)) == hdown + k && GridPane.getRowIndex(whiteimages.get(l)) == row) {
                                            //  System.out.println("ahmad");
                                            borderGlow.setColor(Color.RED);
                                            r[row][hdown + k].setEffect(borderGlow);

                                            borderGlow.setColor(Color.BLUE);

                                        }

                                        checkdown++;
                                    }

                                }
                                if (checkdown == 0 && hdown + k <= 7) {
                                    //   System.out.println("faisal");
                                    r[row][hdown + k].setEffect(borderGlow);

                                }
                            }//checking condition

//                                   if(checkup!=0&&checkdown!=0)
//                                                                             {
//                                                                                 break;
//                                                                               }
//                                    
                        }
                        //}
                        hup = root.getRowIndex(img);
                        hdown = root.getRowIndex(img);
                        //hup= to check up rows
                        //hdown=to check down rows
                        //  if(j==column){
                        checkup1 = 0;
                        checkdown1 = 0;

                        for (int k = 1; k < r.length; k++) {
                            // System.out.println("hassan");
                            if ((hup - k) >= 0 || hdown + k <= 7) {
                                //    System.out.println("ahmad");
                                for (int q = 0; q < blackimages.size(); q++) {
                                    //      System.out.println("faraz");
                                    if ((GridPane.getColumnIndex(blackimages.get(q)) == column && GridPane.getRowIndex(blackimages.get(q)) == hup - k) || (GridPane.getColumnIndex(whiteimages.get(q)) == column && GridPane.getRowIndex(whiteimages.get(q)) == hup - k) && hup - k >= 0 && checkup1 == 0) // if(GridPane.getColumnIndex(whiteimages.get(q))==column&&GridPane.getRowIndex(whiteimages.get(q))==hup-k&&hup-k>=0&&checkup==0&&GridPane.getColumnIndex(blackimages.get(q))!=GridPane.getColumnIndex(blackimages)//&&blackimages.get(q)!=img) 
                                    {
                                        //        System.out.println("talha");
                                        if (GridPane.getRowIndex(whiteimages.get(q)) == hup - k && GridPane.getColumnIndex(whiteimages.get(q)) == column) {
                                            //          System.out.println("fazool");
                                            borderGlow.setColor(Color.RED);
                                            r[hup - k][column].setEffect(borderGlow);

                                            borderGlow.setColor(Color.BLUE);

                                        }
                                        checkup1++;
                                    }
                                }
                                if (checkup1 == 0 && hup - k >= 0) {
                                    r[hup - k][column].setEffect(borderGlow);

                                }

                                for (int l = 0; l < blackimages.size(); l++) {
                                    if ((GridPane.getColumnIndex(blackimages.get(l)) == column && GridPane.getRowIndex(blackimages.get(l)) == hdown + k) || (GridPane.getColumnIndex(whiteimages.get(l)) == column && GridPane.getRowIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7 && checkdown1 == 0) {
                                        if (GridPane.getRowIndex(whiteimages.get(l)) == hdown + k && GridPane.getColumnIndex(whiteimages.get(l)) == column) {
                                            borderGlow.setColor(Color.RED);
                                            r[hdown + k][column].setEffect(borderGlow);

                                            borderGlow.setColor(Color.BLUE);

                                        } else {
                                        }
                                        checkdown1++;
                                    }

                                }
                                if (checkdown1 == 0 && hdown + k <= 7) {
                                    r[hdown + k][column].setEffect(borderGlow);

                                }
                            }//checking condition

                            if (checkup != 0 && checkdown != 0 && checkup1 != 0 && checkdown1 != 0) {
                                break;
                            }

                        }

                        //}
                        //  }
                        //}
                    }
                }
            }
        });

        imghorseblack.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                clear();
                if (imghorseblack.isPressed()) {
                    if (opposite.equals("black")) {
                        name = "blackhorse";
                        for (int i = 0; i < r.length; i++) {
                            for (int j = 0; j < r[i].length; j++) {
                                if (i == row1) {
                                    checkup = 0;
                                    checkup1 = 0;
                                    checkdown = 0;
                                    checkdown1 = 0;
                                    int hup = root.getColumnIndex(imghorseblack);
                                    int hdown = root.getColumnIndex(imghorseblack);

                                    for (int k = 2; k <= 2; k++) {
                                        // for (int t = 0; t < blackimages.size(); t++) {
                                        if ((hup - k) >= 0 || hdown + k <= 7) {
                                            for (int q = 0; q < blackimages.size(); q++) {
                                                if ((GridPane.getRowIndex(blackimages.get(q)) == row1 - 1 && GridPane.getColumnIndex(blackimages.get(q)) == hup - k) || (GridPane.getRowIndex(whiteimages.get(q)) == row1 - 1 && GridPane.getColumnIndex(whiteimages.get(q)) == hup - k) && hup - k >= 0 && checkup == 0 && row1 - 1 >= 0) {

                                                    if (GridPane.getColumnIndex(whiteimages.get(q)) == hup - k && GridPane.getRowIndex(whiteimages.get(q)) == row1 - 1) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[row1 - 1][hup - k].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }
                                                    checkup++;
                                                }
                                            }
                                            if (checkup == 0 && hup - k >= 0 && row1 - 1 >= 0) {
                                                r[row1 - 1][hup - k].setEffect(borderGlow);

                                            }

                                            for (int l = 0; l < blackimages.size(); l++) {

                                                if (checkdown == 0 && row1 - 1 >= 0 && (GridPane.getRowIndex(blackimages.get(l)) == row1 - 1 && GridPane.getColumnIndex(blackimages.get(l)) == hdown + k) || (GridPane.getRowIndex(whiteimages.get(l)) == row1 - 1 && GridPane.getColumnIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7) {
                                                    if (GridPane.getColumnIndex(whiteimages.get(l)) == hdown + k && GridPane.getRowIndex(whiteimages.get(l)) == row1 - 1) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[row1 - 1][hdown + k].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    } else {
                                                    }
                                                    checkdown++;
                                                }

                                            }
                                            if (checkdown == 0 && hdown + k <= 7 && row1 - 1 >= 0) {
                                                r[row1 - 1][hdown + k].setEffect(borderGlow);

                                            }
                                            //////////////////////
                                            for (int q = 0; q < blackimages.size(); q++) {
                                                if ((GridPane.getRowIndex(blackimages.get(q)) == row1 + 1 && GridPane.getColumnIndex(blackimages.get(q)) == hup - k) || (GridPane.getRowIndex(whiteimages.get(q)) == row1 + 1 && GridPane.getColumnIndex(whiteimages.get(q)) == hup - k) && hup - k >= 0 && checkup1 == 0 && row1 + 1 <= 7) {

                                                    if (GridPane.getColumnIndex(whiteimages.get(q)) == hup - k && GridPane.getRowIndex(whiteimages.get(q)) == row1 + 1) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[row1 + 1][hup - k].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }
                                                    checkup1++;
                                                }
                                            }
                                            if (checkup1 == 0 && hup - k >= 0 && row1 + 1 <= 7) {
                                                r[row1 + 1][hup - k].setEffect(borderGlow);

                                            }

                                            for (int l = 0; l < blackimages.size(); l++) {

                                                if (row1 + 1 <= 7 && checkdown1 == 0 && (GridPane.getRowIndex(blackimages.get(l)) == row1 + 1 && GridPane.getColumnIndex(blackimages.get(l)) == hdown + k) || (GridPane.getRowIndex(whiteimages.get(l)) == row1 + 1 && GridPane.getColumnIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7) {
                                                    if (GridPane.getColumnIndex(whiteimages.get(l)) == hdown + k && GridPane.getRowIndex(whiteimages.get(l)) == row1 + 1) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[row1 + 1][hdown + k].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    } else {
                                                    }
                                                    checkdown1++;
                                                }

                                            }
                                            if (checkdown1 == 0 && hdown + k <= 7 && row1 + 1 <= 7) {
                                                r[row1 + 1][hdown + k].setEffect(borderGlow);

                                            }
                                        }//checking condition

                                        if (checkup != 0 && checkdown != 0 && checkup1 != 0 && checkdown != 0) {
                                            break;
                                        }

//                               
                                        //    }
                                    }
                                }
                                int hup = root.getRowIndex(imghorseblack);
                                int hdown = root.getRowIndex(imghorseblack);
                                if (j == column1) {
                                    checkup = 0;
                                    checkup1 = 0;
                                    checkdown = 0;
                                    checkdown1 = 0;

                                    for (int k = 2; k <= 2; k++) {
                                        // for (int t = 0; t < blackimages.size(); t++) {
                                        if ((hup - k) >= 0 || hdown + k <= 7) {
                                            for (int q = 0; q < blackimages.size(); q++) {
                                                if (column1 - 1 >= 0 && (GridPane.getColumnIndex(blackimages.get(q)) == column1 - 1 && GridPane.getRowIndex(blackimages.get(q)) == hup - k) || (GridPane.getColumnIndex(whiteimages.get(q)) == column1 - 1 && GridPane.getRowIndex(whiteimages.get(q)) == hup - k) && hup - k >= 0 && checkup == 0) {

                                                    if (GridPane.getRowIndex(whiteimages.get(q)) == hup - k && GridPane.getColumnIndex(whiteimages.get(q)) == column1 - 1) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[hup - k][column1 - 1].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }
                                                    checkup++;
                                                }
                                            }
                                            if (column1 - 1 >= 0 && checkup == 0 && hup - k >= 0) {
                                                r[hup - k][column1 - 1].setEffect(borderGlow);

                                            }

                                            for (int l = 0; l < blackimages.size(); l++) {

                                                if (column1 - 1 >= 0 && checkdown == 0 && (GridPane.getColumnIndex(blackimages.get(l)) == column1 - 1 && GridPane.getRowIndex(blackimages.get(l)) == hdown + k) || (GridPane.getColumnIndex(whiteimages.get(l)) == column1 - 1 && GridPane.getRowIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7) {
                                                    if (GridPane.getRowIndex(whiteimages.get(l)) == hdown + k && GridPane.getColumnIndex(whiteimages.get(l)) == column1 - 1) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[hdown + k][column1 - 1].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    } else {
                                                    }
                                                    checkdown++;
                                                }

                                            }
                                            if (column1 - 1 >= 0 && checkdown == 0 && hdown + k <= 7) {
                                                r[hdown + k][column1 - 1].setEffect(borderGlow);

                                            }
                                            //////////////////////
                                            for (int q = 0; q < blackimages.size(); q++) {
                                                if (column1 + 1 <= 7 && (GridPane.getColumnIndex(blackimages.get(q)) == column1 + 1 && GridPane.getRowIndex(blackimages.get(q)) == hup - k) || (GridPane.getColumnIndex(whiteimages.get(q)) == column1 + 1 && GridPane.getRowIndex(whiteimages.get(q)) == hup - k) && hup - k >= 0 && checkup1 == 0) {

                                                    if (GridPane.getRowIndex(whiteimages.get(q)) == hup - k && GridPane.getColumnIndex(whiteimages.get(q)) == column1 + 1) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[hup - k][column1 + 1].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }
                                                    checkup1++;
                                                }
                                            }
                                            if (column1 + 1 <= 7 && checkup1 == 0 && hup - k >= 0) {
                                                r[hup - k][column1 + 1].setEffect(borderGlow);

                                            }

                                            for (int l = 0; l < blackimages.size(); l++) {

                                                if (column1 + 1 <= 7 && checkdown1 == 0 && (GridPane.getColumnIndex(blackimages.get(l)) == column1 + 1 && GridPane.getRowIndex(blackimages.get(l)) == hdown + k) || (GridPane.getColumnIndex(whiteimages.get(l)) == column1 + 1 && GridPane.getRowIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7) {
                                                    if (GridPane.getRowIndex(whiteimages.get(l)) == hdown + k && GridPane.getColumnIndex(whiteimages.get(l)) == column1 + 1) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[hdown + k][column1 + 1].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    } else {
                                                    }
                                                    checkdown1++;
                                                }

                                            }
                                            if (column1 + 1 <= 7 && checkdown1 == 0 && hdown + k <= 7) {
                                                r[hdown + k][column1 + 1].setEffect(borderGlow);

                                            }
                                        }//checking condition

                                        if (checkup != 0 && checkdown != 0 && checkup1 != 0 && checkdown1 != 0) {
                                            break;
                                        }

//                               
                                        //    }
                                    }
                                }

                            }
                        }
                    }

                }

            }
        });
        imghorseblack1.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (imghorseblack1.isPressed()) {
                    if (opposite.equals("black")) {
                        clear();
                        name = "blackhorse1";
                        for (int i = 0; i < r.length; i++) {
                            for (int j = 0; j < r[i].length; j++) {
                                if (i == row2) {
                                    checkup = 0;
                                    checkup1 = 0;
                                    checkdown = 0;
                                    checkdown1 = 0;
                                    int hup = root.getColumnIndex(imghorseblack1);
                                    int hdown = root.getColumnIndex(imghorseblack1);

                                    for (int k = 2; k <= 2; k++) {
                                        // for (int t = 0; t < blackimages.size(); t++) {
                                        if ((hup - k) >= 0 || hdown + k <= 7) {
                                            for (int q = 0; q < blackimages.size(); q++) {
                                                if ((GridPane.getRowIndex(blackimages.get(q)) == row2 - 1 && GridPane.getColumnIndex(blackimages.get(q)) == hup - k) || (GridPane.getRowIndex(whiteimages.get(q)) == row2 - 1 && GridPane.getColumnIndex(whiteimages.get(q)) == hup - k) && hup - k >= 0 && checkup == 0 && row2 - 1 >= 0) {

                                                    if (GridPane.getColumnIndex(whiteimages.get(q)) == hup - k && GridPane.getRowIndex(whiteimages.get(q)) == row2 - 1) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[row2 - 1][hup - k].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }
                                                    checkup++;
                                                }
                                            }
                                            if (checkup == 0 && hup - k >= 0 && row2 - 1 >= 0) {
                                                r[row2 - 1][hup - k].setEffect(borderGlow);

                                            }

                                            for (int l = 0; l < blackimages.size(); l++) {

                                                if (checkdown == 0 && row2 - 1 >= 0 && (GridPane.getRowIndex(blackimages.get(l)) == row2 - 1 && GridPane.getColumnIndex(blackimages.get(l)) == hdown + k) || (GridPane.getRowIndex(whiteimages.get(l)) == row2 - 1 && GridPane.getColumnIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7) {
                                                    if (GridPane.getColumnIndex(whiteimages.get(l)) == hdown + k && GridPane.getRowIndex(whiteimages.get(l)) == row2 - 1) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[row2 - 1][hdown + k].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    } else {
                                                    }
                                                    checkdown++;
                                                }

                                            }
                                            if (checkdown == 0 && hdown + k <= 7 && row2 - 1 >= 0) {
                                                r[row2 - 1][hdown + k].setEffect(borderGlow);

                                            }
                                            //////////////////////
                                            for (int q = 0; q < blackimages.size(); q++) {
                                                if ((GridPane.getRowIndex(blackimages.get(q)) == row2 + 1 && GridPane.getColumnIndex(blackimages.get(q)) == hup - k) || (GridPane.getRowIndex(whiteimages.get(q)) == row2 + 1 && GridPane.getColumnIndex(whiteimages.get(q)) == hup - k) && hup - k >= 0 && checkup1 == 0 && row2 + 1 <= 7) {

                                                    if (GridPane.getColumnIndex(whiteimages.get(q)) == hup - k && GridPane.getRowIndex(whiteimages.get(q)) == row2 + 1) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[row2 + 1][hup - k].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }
                                                    checkup1++;
                                                }
                                            }
                                            if (checkup1 == 0 && hup - k >= 0 && row2 + 1 <= 7) {
                                                r[row2 + 1][hup - k].setEffect(borderGlow);

                                            }

                                            for (int l = 0; l < blackimages.size(); l++) {

                                                if (row2 + 1 <= 7 && checkdown1 == 0 && (GridPane.getRowIndex(blackimages.get(l)) == row2 + 1 && GridPane.getColumnIndex(blackimages.get(l)) == hdown + k) || (GridPane.getRowIndex(whiteimages.get(l)) == row2 + 1 && GridPane.getColumnIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7) {
                                                    if (GridPane.getColumnIndex(whiteimages.get(l)) == hdown + k && GridPane.getRowIndex(whiteimages.get(l)) == row2 + 1) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[row2 + 1][hdown + k].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    } else {
                                                    }
                                                    checkdown1++;
                                                }

                                            }
                                            if (checkdown1 == 0 && hdown + k <= 7 && row2 + 1 <= 7) {
                                                r[row2 + 1][hdown + k].setEffect(borderGlow);

                                            }
                                        }//checking condition

                                        if (checkup != 0 && checkdown != 0 && checkup1 != 0 && checkdown != 0) {
                                            break;
                                        }

//                               
                                        //    }
                                    }
                                }
                                int hup = root.getRowIndex(imghorseblack1);
                                int hdown = root.getRowIndex(imghorseblack1);
                                if (j == column2) {
                                    checkup = 0;
                                    checkup1 = 0;
                                    checkdown = 0;
                                    checkdown1 = 0;

                                    for (int k = 2; k <= 2; k++) {
                                        // for (int t = 0; t < blackimages.size(); t++) {
                                        if ((hup - k) >= 0 || hdown + k <= 7) {
                                            for (int q = 0; q < blackimages.size(); q++) {
                                                if (column2 - 1 >= 0 && (GridPane.getColumnIndex(blackimages.get(q)) == column2 - 1 && GridPane.getRowIndex(blackimages.get(q)) == hup - k) || (GridPane.getColumnIndex(whiteimages.get(q)) == column2 - 1 && GridPane.getRowIndex(whiteimages.get(q)) == hup - k) && hup - k >= 0 && checkup == 0) {

                                                    if (GridPane.getRowIndex(whiteimages.get(q)) == hup - k && GridPane.getColumnIndex(whiteimages.get(q)) == column2 - 1) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[hup - k][column2 - 1].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }
                                                    checkup++;
                                                }
                                            }
                                            if (column2 - 1 >= 0 && checkup == 0 && hup - k >= 0) {
                                                r[hup - k][column2 - 1].setEffect(borderGlow);

                                            }

                                            for (int l = 0; l < blackimages.size(); l++) {

                                                if (column2 - 1 >= 0 && checkdown == 0 && (GridPane.getColumnIndex(blackimages.get(l)) == column2 - 1 && GridPane.getRowIndex(blackimages.get(l)) == hdown + k) || (GridPane.getColumnIndex(whiteimages.get(l)) == column2 - 1 && GridPane.getRowIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7) {
                                                    if (GridPane.getRowIndex(whiteimages.get(l)) == hdown + k && GridPane.getColumnIndex(whiteimages.get(l)) == column2 - 1) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[hdown + k][column2 - 1].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    } else {
                                                    }
                                                    checkdown++;
                                                }

                                            }
                                            if (column2 - 1 >= 0 && checkdown == 0 && hdown + k <= 7) {
                                                r[hdown + k][column2 - 1].setEffect(borderGlow);

                                            }
                                            //////////////////////
                                            for (int q = 0; q < blackimages.size(); q++) {
                                                if (column2 + 1 <= 7 && (GridPane.getColumnIndex(blackimages.get(q)) == column2 + 1 && GridPane.getRowIndex(blackimages.get(q)) == hup - k) || (GridPane.getColumnIndex(whiteimages.get(q)) == column2 + 1 && GridPane.getRowIndex(whiteimages.get(q)) == hup - k) && hup - k >= 0 && checkup1 == 0) {

                                                    if (GridPane.getRowIndex(whiteimages.get(q)) == hup - k && GridPane.getColumnIndex(whiteimages.get(q)) == column2 + 1) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[hup - k][column2 + 1].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    }
                                                    checkup1++;
                                                }
                                            }
                                            if (column2 + 1 <= 7 && checkup1 == 0 && hup - k >= 0) {
                                                r[hup - k][column2 + 1].setEffect(borderGlow);

                                            }

                                            for (int l = 0; l < blackimages.size(); l++) {

                                                if (column2 + 1 <= 7 && checkdown1 == 0 && (GridPane.getColumnIndex(blackimages.get(l)) == column2 + 1 && GridPane.getRowIndex(blackimages.get(l)) == hdown + k) || (GridPane.getColumnIndex(whiteimages.get(l)) == column2 + 1 && GridPane.getRowIndex(whiteimages.get(l)) == hdown + k) && hdown + k <= 7) {
                                                    if (GridPane.getRowIndex(whiteimages.get(l)) == hdown + k && GridPane.getColumnIndex(whiteimages.get(l)) == column2 + 1) {
                                                        borderGlow.setColor(Color.RED);
                                                        r[hdown + k][column2 + 1].setEffect(borderGlow);

                                                        borderGlow.setColor(Color.BLUE);

                                                    } else {
                                                    }
                                                    checkdown1++;
                                                }

                                            }
                                            if (column2 + 1 <= 7 && checkdown1 == 0 && hdown + k <= 7) {
                                                r[hdown + k][column2 + 1].setEffect(borderGlow);

                                            }
                                        }//checking condition

                                        if (checkup != 0 && checkdown != 0 && checkup1 != 0 && checkdown1 != 0) {
                                            break;
                                        }

//                               
                                        //    }
                                    }
                                }

                            }
                        }
                    }
                }
            }
        });

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton() == MouseButton.PRIMARY) {
                    for (int i = 0; i < ra.length; i++) {
                        for (int j = 0; j < ra[i].length; j++) {
                            //r[i][j].setEffect(10);
                            // Rectangle cr=ra.get(i);
                            if (ra[i][j].isPressed() && ra[i][j].getEffect() != null) {
//                       if(ra[i][j].contains(event.getX()-35,event.getY()-35)){
                                System.out.println(ra[i][j].getFill());
                                if (name.equals("blackcastle")) {
                                    t.setText("");

                                    int g = GridPane.getRowIndex(img);
                                    int h = GridPane.getColumnIndex(img);

                                    root.getChildren().remove(img);

                                    root.add(img, j, i);
                                    row = i;
                                    column = j;
                                    opposite = "white";
                                    if ((checkblackqueen(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true) || (checkblackpawn(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true) || (checkblackcastle(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true) || (checkblackbishops(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true) || (checkfirst1(GridPane.getRowIndex(imwhiteking), GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking), 0) == true)) {
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);

                                    }
                                    int copyrow = 0;
                                    int copycolumn = 0;
                                   ImageView copy=new ImageView();
                                    for (int l = 0; l < whiteimages.size(); l++) {

                                        if ((GridPane.getRowIndex(whiteimages.get(l)) == i && GridPane.getColumnIndex(whiteimages.get(l)) == j)) {
                                            copy = whiteimages.get(l);
                                            copyrow = GridPane.getRowIndex(copy);
                                            copycolumn = GridPane.getColumnIndex(copy);
                                            whitecolumn.set(l, 10);
                                            whiterow.set(l, 10);
                                            GridPane.setColumnIndex(whiteimages.get(l), 10);
                                            GridPane.setRowIndex(whiteimages.get(l), 10);
                                            System.out.println(whitecolumn.get(l));
                                            System.out.println(whiterow.get(l));
//     
                                            //root.getChildren().remove(blackimages.get(l));
                                            break;
                                        }
                                    }

                                    if (checkwhitequeen(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitepawn(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitecastle(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitebishops(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkfirst(GridPane.getRowIndex(imblackking), GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking), 0) == true) {
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);
                                        root.getChildren().remove(img);

                                        root.add(img, h, g);
                                        row = g;
                                        column = h;
                                        GridPane.setRowIndex(copy,copyrow);
                                        GridPane.setColumnIndex(copy,copycolumn);
                                                opposite = "black";
                                    } 
                                    }

                                 else if (name.equals("whitehorse")) {
                                    t.setText("");

                                    int g = GridPane.getRowIndex(imgwhitehorse);
                                    int h = GridPane.getColumnIndex(imgwhitehorse);

                                    root.getChildren().remove(imgwhitehorse);

                                    root.add(imgwhitehorse, j, i);
                                    rowwhitehorse = i;
                                    columnwhitehorse = j;
                                    opposite = "black";
                                    if (checkwhitequeen(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitepawn(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitecastle(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitebishops(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkfirst(GridPane.getRowIndex(imblackking), GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking), 0) == true) {
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);

//        is.setColor(Color.RED);
//        r[GridPane.getRowIndex(imblackking)][GridPane.getColumnIndex(imblackking)].setEffect(borderGlow);
//      
// System.out.println("hassan");
//        root.add(imcheck,4,4);
//    
                                    }
  int copyrow = 0;
                                    int copycolumn = 0;
                                   ImageView copy=new ImageView();
                                    for (int l = 0; l < blackimages.size(); l++) {

                                        if ((GridPane.getRowIndex(blackimages.get(l)) == i && GridPane.getColumnIndex(blackimages.get(l)) == j)) {
                                            copy = blackimages.get(l);
                                            copyrow = GridPane.getRowIndex(copy);
                                            copycolumn = GridPane.getColumnIndex(copy);
                                            blackcolumn.set(l, 10);
                                            blackrow.set(l, 10);
                                            GridPane.setColumnIndex(blackimages.get(l), 10);
                                            GridPane.setRowIndex(blackimages.get(l), 10);
                                            System.out.println(blackcolumn.get(l));
                                            System.out.println(blackrow.get(l));
//     
                                            //root.getChildren().remove(blackimages.get(l));
                                            break;
                                        }
                                    }

                                    if (checkblackqueen(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackpawn(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackcastle(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackbishops(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkfirst1(GridPane.getRowIndex(imwhiteking), GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking), 0) == true) {
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);
                                        root.getChildren().remove(imgwhitehorse);

                                        root.add(imgwhitehorse, h, g);
                                        rowwhitehorse = g;
                                        columnwhitehorse = h;
                                      GridPane.setRowIndex(copy,copyrow);
                                      GridPane.setColumnIndex(copy,copycolumn);
                                    
                                        opposite = "white";

                                    }
                                } else if (name.equals("whitehorse1")) {
                                    t.setText("");

                                    int g = GridPane.getRowIndex(imgwhitehorse1);
                                    int h = GridPane.getColumnIndex(imgwhitehorse1);

                                    root.getChildren().remove(imgwhitehorse1);

                                    root.add(imgwhitehorse1, j, i);
                                    rowwhitehorse1 = i;
                                    columnwhitehorse1 = j;
                                    opposite = "black";

                                    if (checkwhitequeen(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitepawn(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitecastle(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitebishops(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkfirst(GridPane.getRowIndex(imblackking), GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking), 0) == true) {
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);

//        is.setColor(Color.RED);
//        r[GridPane.getRowIndex(imblackking)][GridPane.getColumnIndex(imblackking)].setEffect(borderGlow);
//      
// System.out.println("hassan");
//        root.add(imcheck,4,4);
//    
                                    }
      int copyrow = 0;
                                    int copycolumn = 0;
                                   ImageView copy=new ImageView();
                                    for (int l = 0; l < blackimages.size(); l++) {

                                        if ((GridPane.getRowIndex(blackimages.get(l)) == i && GridPane.getColumnIndex(blackimages.get(l)) == j)) {
                                            copy = blackimages.get(l);
                                            copyrow = GridPane.getRowIndex(copy);
                                            copycolumn = GridPane.getColumnIndex(copy);
                                            blackcolumn.set(l, 10);
                                            blackrow.set(l, 10);
                                            GridPane.setColumnIndex(blackimages.get(l), 10);
                                            GridPane.setRowIndex(blackimages.get(l), 10);
                                            System.out.println(blackcolumn.get(l));
                                            System.out.println(blackrow.get(l));
//     
                                            //root.getChildren().remove(blackimages.get(l));
                                            break;
                                        }
                                    }


                                    if (checkblackqueen(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackpawn(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackcastle(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackbishops(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkfirst1(GridPane.getRowIndex(imwhiteking), GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking), 0) == true) {
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);
                                        root.getChildren().remove(imgwhitehorse1);

                                        root.add(imgwhitehorse1, h, g);
                                        rowwhitehorse1 = g;
                                        columnwhitehorse1 = h;
                                      GridPane.setRowIndex(copy,copyrow);
                                      GridPane.setColumnIndex(copy,copycolumn);
                                        opposite = "white";

                                    } 

                                } else if (name.equals("blackhorse")) {
                                    t.setText("");

                                    int g = GridPane.getRowIndex(imghorseblack);
                                    int h = GridPane.getColumnIndex(imghorseblack);

                                    root.getChildren().remove(imghorseblack);

                                    root.add(imghorseblack, j, i);

                                    row1 = i;
                                    column1 = j;
                                    opposite = "white";
                                                                      int copyrow = 0;
                                    int copycolumn = 0;
                                   ImageView copy=new ImageView();
                                    for (int l = 0; l < whiteimages.size(); l++) {

                                        if ((GridPane.getRowIndex(whiteimages.get(l)) == i && GridPane.getColumnIndex(whiteimages.get(l)) == j)) {
                                            copy = whiteimages.get(l);
                                            copyrow = GridPane.getRowIndex(copy);
                                            copycolumn = GridPane.getColumnIndex(copy);
                                            whitecolumn.set(l, 10);
                                            whiterow.set(l, 10);
                                            GridPane.setColumnIndex(whiteimages.get(l), 10);
                                            GridPane.setRowIndex(whiteimages.get(l), 10);
                                            System.out.println(whitecolumn.get(l));
                                            System.out.println(whiterow.get(l));
//     
                                            //root.getChildren().remove(blackimages.get(l));
                                            break;
                                        }
                                    }

                                    if (checkwhitequeen(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitepawn(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitecastle(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitebishops(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkfirst(GridPane.getRowIndex(imblackking), GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking), 0) == true) {
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);
                                        root.getChildren().remove(imghorseblack);

                                        root.add(imghorseblack, h, g);
                                        row1 = g;
                                        column1 = h;
                                              GridPane.setRowIndex(copy,copyrow);
                                    GridPane.setColumnIndex(copy,copycolumn);

                                        opposite = "black";

                                    }

                                    if (checkblackqueen(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackpawn(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackcastle(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackbishops(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkfirst1(GridPane.getRowIndex(imwhiteking), GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking), 0) == true) {
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);

                                    }

                                } else if (name.equals("blackhorse1")) {
                                    t.setText("");

                                    int g = GridPane.getRowIndex(imghorseblack1);
                                    int h = GridPane.getColumnIndex(imghorseblack1);

                                    root.getChildren().remove(imghorseblack1);

                                    root.add(imghorseblack1, j, i);
                                    row2 = i;
                                    column2 = j;
                                    opposite = "white";
                                                                        int copyrow = 0;
                                    int copycolumn = 0;
                                   ImageView copy=new ImageView();
                                    for (int l = 0; l < whiteimages.size(); l++) {

                                        if ((GridPane.getRowIndex(whiteimages.get(l)) == i && GridPane.getColumnIndex(whiteimages.get(l)) == j)) {
                                            copy = whiteimages.get(l);
                                            copyrow = GridPane.getRowIndex(copy);
                                            copycolumn = GridPane.getColumnIndex(copy);
                                            whitecolumn.set(l, 10);
                                            whiterow.set(l, 10);
                                            GridPane.setColumnIndex(whiteimages.get(l), 10);
                                            GridPane.setRowIndex(whiteimages.get(l), 10);
                                            System.out.println(whitecolumn.get(l));
                                            System.out.println(whiterow.get(l));
//     
                                            //root.getChildren().remove(blackimages.get(l));
                                            break;
                                        }
                                    }

                                    if (checkwhitequeen(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitepawn(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitecastle(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitebishops(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkfirst(GridPane.getRowIndex(imblackking), GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking), 0) == true) {
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);
                                        root.getChildren().remove(imghorseblack1);

                                        root.add(imghorseblack1, h, g);
                                        row2 = g;
                                        column2 = h;
                                        
                                              GridPane.setRowIndex(copy,copyrow);
                                    GridPane.setColumnIndex(copy,copycolumn);

                                        opposite = "black";

//        is.setColor(Color.RED);
//        r[GridPane.getRowIndex(imblackking)][GridPane.getColumnIndex(imblackking)].setEffect(borderGlow);
//      
// System.out.println("hassan");
//        root.add(imcheck,4,4);
//    
                                    } 
                                        if (checkblackqueen(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackpawn(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackcastle(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackbishops(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkfirst1(GridPane.getRowIndex(imwhiteking), GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking), 0) == true) {
                                            t.setText("Checked");
                                            // t.setX(300);
                                            //t.setY(150);
                                            t.setFont(Font.font(20));
                                            t.setFill(Color.RED);
                                            t.setStroke(Color.RED);
                                            t.setStrokeWidth(2);

                                        }

                                    

                                } else if (name.equals("whitepawn1")) {
                                    t.setText("");

                                    int g = GridPane.getRowIndex(imgwhite);
                                    int h = GridPane.getColumnIndex(imgwhite);

                                    root.getChildren().remove(imgwhite);

                                    root.add(imgwhite, j, i);
                                    rowwhitepiece = i;
                                    columnwhitepiece = j;
                                    opposite = "black";
                                    if (checkwhitequeen(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitepawn(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitecastle(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitebishops(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkfirst(GridPane.getRowIndex(imblackking), GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking), 0) == true) {
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);

                                    }
                                    int copyrow = 0;
                                    int copycolumn = 0;
                                   ImageView copy=new ImageView();
                                    for (int l = 0; l < blackimages.size(); l++) {

                                        if ((GridPane.getRowIndex(blackimages.get(l)) == i && GridPane.getColumnIndex(blackimages.get(l)) == j)) {
                                            copy = blackimages.get(l);
                                            copyrow = GridPane.getRowIndex(copy);
                                            copycolumn = GridPane.getColumnIndex(copy);
                                            blackcolumn.set(l, 10);
                                            blackrow.set(l, 10);
                                            GridPane.setColumnIndex(blackimages.get(l), 10);
                                            GridPane.setRowIndex(blackimages.get(l), 10);
                                            System.out.println(blackcolumn.get(l));
                                            System.out.println(blackrow.get(l));
//     
                                            //root.getChildren().remove(blackimages.get(l));
                                            break;
                                        }
                                    }


                                    if (checkblackqueen(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackpawn(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackcastle(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackbishops(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkfirst1(GridPane.getRowIndex(imwhiteking), GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking), 0) == true) {
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);
                                        root.getChildren().remove(imgwhite);

                                        root.add(imgwhite, h, g);
                                        rowwhitepiece = g;
                                        columnwhitepiece = h;
                                              GridPane.setRowIndex(copy,copyrow);
                                    GridPane.setColumnIndex(copy,copycolumn);


                                        opposite = "white";

                                    }
                                } else if (name.equals("whitepawn2")) {
                                    t.setText("");
                                    int g = GridPane.getRowIndex(imgwhite1);
                                    int h = GridPane.getColumnIndex(imgwhite1);

                                    root.getChildren().remove(imgwhite1);

                                    root.add(imgwhite1, j, i);
                                    rowwhitepiece1 = i;
                                    columnwhitepiece1 = j;
                                    opposite = "black";
                                    if (checkwhitequeen(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitepawn(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitecastle(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitebishops(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkfirst(GridPane.getRowIndex(imblackking), GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking), 0) == true) {
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);
                                    }int copyrow = 0;
                                    int copycolumn = 0;
                                   ImageView copy=new ImageView();
                                    for (int l = 0; l < blackimages.size(); l++) {

                                        if ((GridPane.getRowIndex(blackimages.get(l)) == i && GridPane.getColumnIndex(blackimages.get(l)) == j)) {
                                            copy = blackimages.get(l);
                                            copyrow = GridPane.getRowIndex(copy);
                                            copycolumn = GridPane.getColumnIndex(copy);
                                            blackcolumn.set(l, 10);
                                            blackrow.set(l, 10);
                                            GridPane.setColumnIndex(blackimages.get(l), 10);
                                            GridPane.setRowIndex(blackimages.get(l), 10);
                                            System.out.println(blackcolumn.get(l));
                                            System.out.println(blackrow.get(l));
//     
                                            //root.getChildren().remove(blackimages.get(l));
                                            break;
                                        }
                                    }


                                    if (checkblackqueen(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackpawn(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackcastle(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackbishops(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkfirst1(GridPane.getRowIndex(imwhiteking), GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking), 0) == true) {
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);

                                        root.getChildren().remove(imgwhite1);

                                        root.add(imgwhite1, h, g);
                                        rowwhitepiece1 = g;
                                        columnwhitepiece1 = h;
                                              GridPane.setRowIndex(copy,copyrow);
                                    GridPane.setColumnIndex(copy,copycolumn);

                                        opposite = "white";

                                    }

                                } else if (name.equals("whitepawn3")) {
                                    t.setText("");
                                    int g = GridPane.getRowIndex(imgwhite2);
                                    int h = GridPane.getColumnIndex(imgwhite2);

                                    root.getChildren().remove(imgwhite2);

                                    root.add(imgwhite2, j, i);
                                    rowwhitepiece2 = i;
                                    columnwhitepiece2 = j;
                                    opposite = "black";
                                    if (checkwhitequeen(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitepawn(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitecastle(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitebishops(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkfirst(GridPane.getRowIndex(imblackking), GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking), 0) == true) {
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);

//        is.setColor(Color.RED);
//        r[GridPane.getRowIndex(imblackking)][GridPane.getColumnIndex(imblackking)].setEffect(borderGlow);
//      
// System.out.println("hassan");
//        root.add(imcheck,4,4);
//    
                                    }int copyrow = 0;
                                    int copycolumn = 0;
                                   ImageView copy=new ImageView();
                                    for (int l = 0; l < blackimages.size(); l++) {

                                        if ((GridPane.getRowIndex(blackimages.get(l)) == i && GridPane.getColumnIndex(blackimages.get(l)) == j)) {
                                            copy = blackimages.get(l);
                                            copyrow = GridPane.getRowIndex(copy);
                                            copycolumn = GridPane.getColumnIndex(copy);
                                            blackcolumn.set(l, 10);
                                            blackrow.set(l, 10);
                                            GridPane.setColumnIndex(blackimages.get(l), 10);
                                            GridPane.setRowIndex(blackimages.get(l), 10);
                                            System.out.println(blackcolumn.get(l));
                                            System.out.println(blackrow.get(l));
//     
                                            //root.getChildren().remove(blackimages.get(l));
                                            break;
                                        }
                                    }


                                    if (checkblackqueen(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackpawn(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackcastle(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackbishops(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkfirst1(GridPane.getRowIndex(imwhiteking), GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking), 0) == true) {
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);

                                        root.getChildren().remove(imgwhite2);

                                        root.add(imgwhite2, h, g);
                                        rowwhitepiece2 = g;
                                        columnwhitepiece2 = h;
                                              GridPane.setRowIndex(copy,copyrow);
                                    GridPane.setColumnIndex(copy,copycolumn);

                                        opposite = "white";

                                    }
                                } else if (name.equals("whitepawn4")) {
                                    t.setText("");
                                    int g = GridPane.getRowIndex(imgwhite3);
                                    int h = GridPane.getColumnIndex(imgwhite3);

                                    root.getChildren().remove(imgwhite3);

                                    root.add(imgwhite3, j, i);
                                    rowwhitepiece3 = i;
                                    columnwhitepiece3 = j;
                                    opposite = "black";
                                    if (checkwhitequeen(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitepawn(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitecastle(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitebishops(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkfirst(GridPane.getRowIndex(imblackking), GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking), 0) == true) {
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);

//        is.setColor(Color.RED);
//        r[GridPane.getRowIndex(imblackking)][GridPane.getColumnIndex(imblackking)].setEffect(borderGlow);
//      
// System.out.println("hassan");
//        root.add(imcheck,4,4);
//    
                                    }
                                    int copyrow = 0;
                                    int copycolumn = 0;
                                   ImageView copy=new ImageView();
                                    for (int l = 0; l < blackimages.size(); l++) {

                                        if ((GridPane.getRowIndex(blackimages.get(l)) == i && GridPane.getColumnIndex(blackimages.get(l)) == j)) {
                                            copy = blackimages.get(l);
                                            copyrow = GridPane.getRowIndex(copy);
                                            copycolumn = GridPane.getColumnIndex(copy);
                                            blackcolumn.set(l, 10);
                                            blackrow.set(l, 10);
                                            GridPane.setColumnIndex(blackimages.get(l), 10);
                                            GridPane.setRowIndex(blackimages.get(l), 10);
                                            System.out.println(blackcolumn.get(l));
                                            System.out.println(blackrow.get(l));
//     
                                            //root.getChildren().remove(blackimages.get(l));
                                            break;
                                        }
                                    }


                                    if (checkblackqueen(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackpawn(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackcastle(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackbishops(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkfirst1(GridPane.getRowIndex(imwhiteking), GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking), 0) == true) {
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);

                                        root.getChildren().remove(imgwhite3);

                                        root.add(imgwhite3, h, g);
                                        rowwhitepiece3 = g;
                                        columnwhitepiece3 = h;
                                              GridPane.setRowIndex(copy,copyrow);
                                    GridPane.setColumnIndex(copy,copycolumn);

                                        opposite = "white";

                                    }
                                } else if (name.equals("whitepawn5")) {
                                    t.setText("");
                                    int g = GridPane.getRowIndex(imgwhite4);
                                    int h = GridPane.getColumnIndex(imgwhite4);

                                    root.getChildren().remove(imgwhite4);

                                    root.add(imgwhite4, j, i);
                                    rowwhitepiece4 = i;
                                    columnwhitepiece4 = j;
                                    opposite = "black";
                                    if (checkwhitequeen(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitepawn(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitecastle(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitebishops(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkfirst(GridPane.getRowIndex(imblackking), GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking), 0) == true) {
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);

//        is.setColor(Color.RED);
//        r[GridPane.getRowIndex(imblackking)][GridPane.getColumnIndex(imblackking)].setEffect(borderGlow);
//      
// System.out.println("hassan");
//        root.add(imcheck,4,4);
//    
                                    }
int copyrow = 0;
                                    int copycolumn = 0;
                                   ImageView copy=new ImageView();
                                    for (int l = 0; l < blackimages.size(); l++) {

                                        if ((GridPane.getRowIndex(blackimages.get(l)) == i && GridPane.getColumnIndex(blackimages.get(l)) == j)) {
                                            copy = blackimages.get(l);
                                            copyrow = GridPane.getRowIndex(copy);
                                            copycolumn = GridPane.getColumnIndex(copy);
                                            blackcolumn.set(l, 10);
                                            blackrow.set(l, 10);
                                            GridPane.setColumnIndex(blackimages.get(l), 10);
                                            GridPane.setRowIndex(blackimages.get(l), 10);
                                            System.out.println(blackcolumn.get(l));
                                            System.out.println(blackrow.get(l));
//     
                                            //root.getChildren().remove(blackimages.get(l));
                                            break;
                                        }
                                    }
                                    if (checkblackqueen(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackpawn(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackcastle(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackbishops(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkfirst1(GridPane.getRowIndex(imwhiteking), GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking), 0) == true) {
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);

                                        root.getChildren().remove(imgwhite4);

                                        root.add(imgwhite4, h, g);
                                        rowwhitepiece4 = g;
                                        columnwhitepiece4 = h;
                                              GridPane.setRowIndex(copy,copyrow);
                                    GridPane.setColumnIndex(copy,copycolumn);

                                        opposite = "white";

                                    } 
                                } else if (name.equals("whitepawn6")) {
                                    t.setText("");
                                    int g = GridPane.getRowIndex(imgwhite5);
                                    int h = GridPane.getColumnIndex(imgwhite5);

                                    root.getChildren().remove(imgwhite5);

                                    root.add(imgwhite5, j, i);
                                    rowwhitepiece5 = i;
                                    columnwhitepiece5 = j;
                                    opposite = "black";
                                    if (checkwhitequeen(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitepawn(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitecastle(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitebishops(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkfirst(GridPane.getRowIndex(imblackking), GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking), 0) == true) {
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);

//        is.setColor(Color.RED);
//        r[GridPane.getRowIndex(imblackking)][GridPane.getColumnIndex(imblackking)].setEffect(borderGlow);
//      
// System.out.println("hassan");
//        root.add(imcheck,4,4);
//    
                                    }
                                    
                                      int copyrow = 0;
                                    int copycolumn = 0;
                                   ImageView copy=new ImageView();
                                    for (int l = 0; l < blackimages.size(); l++) {

                                        if ((GridPane.getRowIndex(blackimages.get(l)) == i && GridPane.getColumnIndex(blackimages.get(l)) == j)) {
                                            copy = blackimages.get(l);
                                            copyrow = GridPane.getRowIndex(copy);
                                            copycolumn = GridPane.getColumnIndex(copy);
                                            blackcolumn.set(l, 10);
                                            blackrow.set(l, 10);
                                            GridPane.setColumnIndex(blackimages.get(l), 10);
                                            GridPane.setRowIndex(blackimages.get(l), 10);
                                            System.out.println(blackcolumn.get(l));
                                            System.out.println(blackrow.get(l));
//     
                                            //root.getChildren().remove(blackimages.get(l));
                                            break;
                                        }
                                    }


                                    if (checkblackqueen(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackpawn(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackcastle(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackbishops(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkfirst1(GridPane.getRowIndex(imwhiteking), GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking), 0) == true) {
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);

                                        root.getChildren().remove(imgwhite5);

                                        root.add(imgwhite5, h, g);
                                        rowwhitepiece5 = g;
                                        columnwhitepiece5 = h;
                                              GridPane.setRowIndex(copy,copyrow);
                                    GridPane.setColumnIndex(copy,copycolumn);

                                        opposite = "white";

                                    } 
                                } else if (name.equals("whitepawn7")) {
                                    t.setText("");
                                    int g = GridPane.getRowIndex(imgwhite6);
                                    int h = GridPane.getColumnIndex(imgwhite6);

                                    root.getChildren().remove(imgwhite6);

                                    root.add(imgwhite6, j, i);
                                    rowwhitepiece6 = i;
                                    columnwhitepiece6 = j;

                                    opposite = "black";
                                    if (checkwhitequeen(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitepawn(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitecastle(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitebishops(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkfirst(GridPane.getRowIndex(imblackking), GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking), 0) == true) {

                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);

//        is.setColor(Color.RED);
//        r[GridPane.getRowIndex(imblackking)][GridPane.getColumnIndex(imblackking)].setEffect(borderGlow);
//      
// System.out.println("hassan");
//        root.add(imcheck,4,4);
//    
                                    }

                                      int copyrow = 0;
                                    int copycolumn = 0;
                                   ImageView copy=new ImageView();
                                    for (int l = 0; l < blackimages.size(); l++) {

                                        if ((GridPane.getRowIndex(blackimages.get(l)) == i && GridPane.getColumnIndex(blackimages.get(l)) == j)) {
                                            copy = blackimages.get(l);
                                            copyrow = GridPane.getRowIndex(copy);
                                            copycolumn = GridPane.getColumnIndex(copy);
                                            blackcolumn.set(l, 10);
                                            blackrow.set(l, 10);
                                            GridPane.setColumnIndex(blackimages.get(l), 10);
                                            GridPane.setRowIndex(blackimages.get(l), 10);
                                            System.out.println(blackcolumn.get(l));
                                            System.out.println(blackrow.get(l));
//     
                                            //root.getChildren().remove(blackimages.get(l));
                                            break;
                                        }
                                    }

                                    if (checkblackqueen(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackpawn(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackcastle(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackbishops(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkfirst1(GridPane.getRowIndex(imwhiteking), GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking), 0) == true) {
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);

                                        root.getChildren().remove(imgwhite6);

                                        root.add(imgwhite6, h, g);
                                        rowwhitepiece6 = g;
                                        columnwhitepiece6 = h;
                                      GridPane.setRowIndex(copy,copyrow);
                                    GridPane.setColumnIndex(copy,copycolumn);
                                    
                                  
                                        opposite = "white";

                                    } 
                                } else if (name.equals("whitepawn8")) {
                                    t.setText("");

                                    int g = GridPane.getRowIndex(imgwhite7);
                                    int h = GridPane.getColumnIndex(imgwhite7);

                                    root.getChildren().remove(imgwhite7);

                                    root.add(imgwhite7, j, i);
                                    rowwhitepiece7 = i;
                                    columnwhitepiece7 = j;
                                    opposite = "black";

                                    if (checkwhitequeen(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitepawn(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitecastle(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitebishops(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkfirst(GridPane.getRowIndex(imblackking), GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking), 0) == true) {
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);

//        is.setColor(Color.RED);
//        r[GridPane.getRowIndex(imblackking)][GridPane.getColumnIndex(imblackking)].setEffect(borderGlow);
//      
// System.out.println("hassan");
//        root.add(imcheck,4,4);
//    
                                    }
                                      int copyrow = 0;
                                    int copycolumn = 0;
                                   ImageView copy=new ImageView();
                                    for (int l = 0; l < blackimages.size(); l++) {

                                        if ((GridPane.getRowIndex(blackimages.get(l)) == i && GridPane.getColumnIndex(blackimages.get(l)) == j)) {
                                            copy = blackimages.get(l);
                                            copyrow = GridPane.getRowIndex(copy);
                                            copycolumn = GridPane.getColumnIndex(copy);
                                            blackcolumn.set(l, 10);
                                            blackrow.set(l, 10);
                                            GridPane.setColumnIndex(blackimages.get(l), 10);
                                            GridPane.setRowIndex(blackimages.get(l), 10);
                                            System.out.println(blackcolumn.get(l));
                                            System.out.println(blackrow.get(l));
//     
                                            //root.getChildren().remove(blackimages.get(l));
                                            break;
                                        }
                                    }

                                    if (checkblackqueen(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackpawn(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackcastle(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackbishops(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkfirst1(GridPane.getRowIndex(imwhiteking), GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking), 0) == true) {
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);

                                        root.getChildren().remove(imgwhite7);

                                        root.add(imgwhite7, h, g);
                                        rowwhitepiece7 = g;
                                        columnwhitepiece7 = h;
                                      GridPane.setRowIndex(copy,copyrow);
                                    GridPane.setColumnIndex(copy,copycolumn);
                                    
                                        opposite = "white";

                                    } 
                                } else if (name.equals("blackpawn1")) {
                                    t.setText("");

                                    int g = GridPane.getRowIndex(imblackpiece);
                                    int h = GridPane.getColumnIndex(imblackpiece);

                                    root.getChildren().remove(imblackpiece);

                                    root.add(imblackpiece, j, i);
                                    rowblackpiece = i;
                                    columnblackpiece = j;
                                    opposite = "white";
                                     int copyrow = 0;
                                    int copycolumn = 0;
                                   ImageView copy=new ImageView();
                                    for (int l = 0; l < whiteimages.size(); l++) {

                                        if ((GridPane.getRowIndex(whiteimages.get(l)) == i && GridPane.getColumnIndex(whiteimages.get(l)) == j)) {
                                            copy = whiteimages.get(l);
                                            copyrow = GridPane.getRowIndex(copy);
                                            copycolumn = GridPane.getColumnIndex(copy);
                                            whitecolumn.set(l, 10);
                                            whiterow.set(l, 10);
                                            GridPane.setColumnIndex(whiteimages.get(l), 10);
                                            GridPane.setRowIndex(whiteimages.get(l), 10);
                                            System.out.println(whitecolumn.get(l));
                                            System.out.println(whiterow.get(l));
//     
                                            //root.getChildren().remove(blackimages.get(l));
                                            break;
                                        }
                                    }
                                    if (checkwhitequeen(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitepawn(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitecastle(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitebishops(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkfirst(GridPane.getRowIndex(imblackking), GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking), 0) == true) {
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);

                                        root.getChildren().remove(imblackpiece);

                                        root.add(imblackpiece, h, g);
                                        rowblackpiece = g;
                                        columnblackpiece = h;
                                    GridPane.setRowIndex(copy,copyrow);
                                    GridPane.setColumnIndex(copy,copycolumn);
                                    
                                        opposite = "black";

//        is.setColor(Color.RED);
//        r[GridPane.getRowIndex(imblackking)][GridPane.getColumnIndex(imblackking)].setEffect(borderGlow);
//      
// System.out.println("hassan");
//        root.add(imcheck,4,4);
//    
                                    }

                                    if (checkblackqueen(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackpawn(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackcastle(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackbishops(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkfirst1(GridPane.getRowIndex(imwhiteking), GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking), 0) == true) {
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);

                                    }
                                } else if (name.equals("blackpawn2")) {
                                    t.setText("");

                                    int g = GridPane.getRowIndex(imblackpiece1);
                                    int h = GridPane.getColumnIndex(imblackpiece1);

                                    root.getChildren().remove(imblackpiece1);

                                    root.add(imblackpiece1, j, i);
                                    rowblackpiece1 = i;
                                    columnblackpiece1 = j;
                                    opposite = "white";

                                       int copyrow = 0;
                                    int copycolumn = 0;
                                   ImageView copy=new ImageView();
                                    for (int l = 0; l < whiteimages.size(); l++) {

                                        if ((GridPane.getRowIndex(whiteimages.get(l)) == i && GridPane.getColumnIndex(whiteimages.get(l)) == j)) {
                                            copy = whiteimages.get(l);
                                            copyrow = GridPane.getRowIndex(copy);
                                            copycolumn = GridPane.getColumnIndex(copy);
                                            whitecolumn.set(l, 10);
                                            whiterow.set(l, 10);
                                            GridPane.setColumnIndex(whiteimages.get(l), 10);
                                            GridPane.setRowIndex(whiteimages.get(l), 10);
                                            System.out.println(whitecolumn.get(l));
                                            System.out.println(whiterow.get(l));
//     
                                            //root.getChildren().remove(blackimages.get(l));
                                            break;
                                        }
                                    }
                                    if (checkwhitequeen(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitepawn(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitecastle(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitebishops(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkfirst(GridPane.getRowIndex(imblackking), GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking), 0) == true) {
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);
                                        root.getChildren().remove(imblackpiece1);
                                        root.add(imblackpiece1, h, g);
                                        rowblackpiece1 = g;
                                        columnblackpiece1 = h;
                                    GridPane.setRowIndex(copy,copyrow);
                                    GridPane.setColumnIndex(copy,copycolumn);
                                    
                                        opposite = "black";

//        is.setColor(Color.RED);
//        r[GridPane.getRowIndex(imblackking)][GridPane.getColumnIndex(imblackking)].setEffect(borderGlow);
//      
// System.out.println("hassan");
//        root.add(imcheck,4,4);
//    
                                    }

                                    if (checkblackqueen(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackpawn(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackcastle(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackbishops(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkfirst1(GridPane.getRowIndex(imwhiteking), GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking), 0) == true) {
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);

                                    }

                                } else if (name.equals("blackpawn3")) {
                                    t.setText("");

                                    int g = GridPane.getRowIndex(imblackpiece2);
                                    int h = GridPane.getColumnIndex(imblackpiece2);

                                    root.getChildren().remove(imblackpiece2);

                                    root.add(imblackpiece2, j, i);
                                    rowblackpiece2 = i;
                                    columnblackpiece2 = j;
                                    opposite = "white";
                                       int copyrow = 0;
                                    int copycolumn = 0;
                                   ImageView copy=new ImageView();
                                    for (int l = 0; l < whiteimages.size(); l++) {

                                        if ((GridPane.getRowIndex(whiteimages.get(l)) == i && GridPane.getColumnIndex(whiteimages.get(l)) == j)) {
                                            copy = whiteimages.get(l);
                                            copyrow = GridPane.getRowIndex(copy);
                                            copycolumn = GridPane.getColumnIndex(copy);
                                            whitecolumn.set(l, 10);
                                            whiterow.set(l, 10);
                                            GridPane.setColumnIndex(whiteimages.get(l), 10);
                                            GridPane.setRowIndex(whiteimages.get(l), 10);
                                            System.out.println(whitecolumn.get(l));
                                            System.out.println(whiterow.get(l));
//     
                                            //root.getChildren().remove(blackimages.get(l));
                                            break;
                                        }
                                    }
                                    if (checkwhitequeen(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitepawn(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitecastle(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitebishops(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkfirst(GridPane.getRowIndex(imblackking), GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking), 0) == true) {
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);
                                        root.getChildren().remove(imblackpiece2);
                                        root.add(imblackpiece2, h, g);
                                        rowblackpiece2 = g;
                                        columnblackpiece2 = h;
                                    GridPane.setRowIndex(copy,copyrow);
                                    GridPane.setColumnIndex(copy,copycolumn);
                                    
                                        opposite = "black";
//        is.setColor(Color.RED);
//        r[GridPane.getRowIndex(imblackking)][GridPane.getColumnIndex(imblackking)].setEffect(borderGlow);
//      
// System.out.println("hassan");
//        root.add(imcheck,4,4);
//    

                                    }

                                    if (checkblackqueen(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackpawn(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackcastle(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackbishops(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkfirst1(GridPane.getRowIndex(imwhiteking), GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking), 0) == true) {
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);

                                    }

                                } else if (name.equals("blackpawn4")) {
                                    t.setText("");

                                    int g = GridPane.getRowIndex(imblackpiece3);
                                    int h = GridPane.getColumnIndex(imblackpiece3);

                                    root.getChildren().remove(imblackpiece3);

                                    root.add(imblackpiece3, j, i);
                                    rowblackpiece3 = i;
                                    columnblackpiece3 = j;
                                    opposite = "white";
                                    int copyrow = 0;
                                    int copycolumn = 0;
                                   ImageView copy=new ImageView();
                                    for (int l = 0; l < whiteimages.size(); l++) {

                                        if ((GridPane.getRowIndex(whiteimages.get(l)) == i && GridPane.getColumnIndex(whiteimages.get(l)) == j)) {
                                            copy = whiteimages.get(l);
                                            copyrow = GridPane.getRowIndex(copy);
                                            copycolumn = GridPane.getColumnIndex(copy);
                                            whitecolumn.set(l, 10);
                                            whiterow.set(l, 10);
                                            GridPane.setColumnIndex(whiteimages.get(l), 10);
                                            GridPane.setRowIndex(whiteimages.get(l), 10);
                                            System.out.println(whitecolumn.get(l));
                                            System.out.println(whiterow.get(l));
//     
                                            //root.getChildren().remove(blackimages.get(l));
                                            break;
                                        }
                                    }
                                    if (checkwhitequeen(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitepawn(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitecastle(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitebishops(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkfirst(GridPane.getRowIndex(imblackking), GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking), 0) == true) {
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);
                                        root.getChildren().remove(imblackpiece3);
                                        root.add(imblackpiece3, h, g);
                                        rowblackpiece3 = g;
                                        columnblackpiece3 = h;
                                    GridPane.setRowIndex(copy,copyrow);
                                    GridPane.setColumnIndex(copy,copycolumn);
                                        opposite = "black";

//        is.setColor(Color.RED);
//        r[GridPane.getRowIndex(imblackking)][GridPane.getColumnIndex(imblackking)].setEffect(borderGlow);
//      
// System.out.println("hassan");
//        root.add(imcheck,4,4);
//    
                                    }

                                    if (checkblackqueen(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackpawn(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackcastle(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackbishops(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkfirst1(GridPane.getRowIndex(imwhiteking), GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking), 0) == true) {
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);

                                    }

                                } else if (name.equals("blackpawn5")) {
                                    t.setText("");

                                    int g = GridPane.getRowIndex(imblackpiece4);
                                    int h = GridPane.getColumnIndex(imblackpiece4);

                                    root.getChildren().remove(imblackpiece4);

                                    root.add(imblackpiece4, j, i);
                                    rowblackpiece4 = i;
                                    columnblackpiece4 = j;

                                    opposite = "white";
                                    int copyrow = 0;
                                    int copycolumn = 0;
                                   ImageView copy=new ImageView();
                                    for (int l = 0; l < whiteimages.size(); l++) {

                                        if ((GridPane.getRowIndex(whiteimages.get(l)) == i && GridPane.getColumnIndex(whiteimages.get(l)) == j)) {
                                            copy = whiteimages.get(l);
                                            copyrow = GridPane.getRowIndex(copy);
                                            copycolumn = GridPane.getColumnIndex(copy);
                                            whitecolumn.set(l, 10);
                                            whiterow.set(l, 10);
                                            GridPane.setColumnIndex(whiteimages.get(l), 10);
                                            GridPane.setRowIndex(whiteimages.get(l), 10);
                                            System.out.println(whitecolumn.get(l));
                                            System.out.println(whiterow.get(l));
//     
                                            //root.getChildren().remove(blackimages.get(l));
                                            break;
                                        }
                                    }
                                    if (checkwhitequeen(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitepawn(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitecastle(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitebishops(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkfirst(GridPane.getRowIndex(imblackking), GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking), 0) == true) {
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);
                                        root.getChildren().remove(imblackpiece4);
                                        root.add(imblackpiece4, h, g);
                                        rowblackpiece4 = g;
                                        columnblackpiece4 = h;
                                      GridPane.setRowIndex(copy,copyrow);
                                      GridPane.setColumnIndex(copy,copycolumn);
                                        opposite = "black";

                                    } 
                                    if (checkblackqueen(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackpawn(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackcastle(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackbishops(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkfirst1(GridPane.getRowIndex(imwhiteking), GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking), 0) == true) {
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);

                                    }

                                } else if (name.equals("blackpawn6")) {
                                    t.setText("");

                                    int g = GridPane.getRowIndex(imblackpiece5);
                                    int h = GridPane.getColumnIndex(imblackpiece5);

                                    root.getChildren().remove(imblackpiece5);

                                    root.add(imblackpiece5, j, i);
                                    rowblackpiece5 = i;
                                    columnblackpiece5 = j;
                                    opposite = "white";
                                   int copyrow = 0;
                                    int copycolumn = 0;
                                   ImageView copy=new ImageView();
                                    for (int l = 0; l < whiteimages.size(); l++) {

                                        if ((GridPane.getRowIndex(whiteimages.get(l)) == i && GridPane.getColumnIndex(whiteimages.get(l)) == j)) {
                                            copy = whiteimages.get(l);
                                            copyrow = GridPane.getRowIndex(copy);
                                            copycolumn = GridPane.getColumnIndex(copy);
                                            whitecolumn.set(l, 10);
                                            whiterow.set(l, 10);
                                            GridPane.setColumnIndex(whiteimages.get(l), 10);
                                            GridPane.setRowIndex(whiteimages.get(l), 10);
                                            System.out.println(whitecolumn.get(l));
                                            System.out.println(whiterow.get(l));
//     
                                            //root.getChildren().remove(blackimages.get(l));
                                            break;
                                        }
                                    }
                                    if (checkwhitequeen(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitepawn(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitecastle(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitebishops(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkfirst(GridPane.getRowIndex(imblackking), GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking), 0) == true) {
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);
                                        root.getChildren().remove(imblackpiece5);
                                        root.add(imblackpiece5, h, g);
                                        rowblackpiece5 = g;
                                        columnblackpiece5 = h;
                                        GridPane.setRowIndex(copy, copyrow);
                                        GridPane.setColumnIndex(copy, copycolumn);

                                        opposite = "black";
//        is.setColor(Color.RED);
//        r[GridPane.getRowIndex(imblackking)][GridPane.getColumnIndex(imblackking)].setEffect(borderGlow);
//      
// System.out.println("hassan");
//        root.add(imcheck,4,4);
//    

                                    }
                                    if (checkblackqueen(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackpawn(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackcastle(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackbishops(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkfirst1(GridPane.getRowIndex(imwhiteking), GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking), 0) == true) {
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);

                                    }

                                } else if (name.equals("blackpawn7")) {
                                    t.setText("");
                                    int g = GridPane.getRowIndex(imblackpiece6);
                                    int h = GridPane.getColumnIndex(imblackpiece6);

                                    root.getChildren().remove(imblackpiece6);

                                    root.add(imblackpiece6, j, i);
                                    rowblackpiece6 = i;
                                    columnblackpiece6 = j;
                                    opposite = "white";
                                    ImageView copy = new ImageView();
                                    int copyrow = 0;
                                    int copycolumn = 0;
                                    for (int l = 0; l < whiteimages.size(); l++) {

                                        if ((GridPane.getRowIndex(whiteimages.get(l)) == i && GridPane.getColumnIndex(whiteimages.get(l)) == j)) {
                                            copy = whiteimages.get(l);
                                            copyrow = GridPane.getRowIndex(copy);
                                            copycolumn = GridPane.getColumnIndex(copy);
                                            whitecolumn.set(l, 10);
                                            whiterow.set(l, 10);
                                            GridPane.setColumnIndex(whiteimages.get(l), 10);
                                            GridPane.setRowIndex(whiteimages.get(l), 10);
                                            System.out.println(whitecolumn.get(l));
                                            System.out.println(whiterow.get(l));
//     
                                            //root.getChildren().remove(blackimages.get(l));
                                            break;
                                        }
                                    }
                                    if (checkwhitequeen(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitepawn(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitecastle(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitebishops(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkfirst(GridPane.getRowIndex(imblackking), GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking), 0) == true) {
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);
                                        root.getChildren().remove(imblackpiece6);
                                        root.add(imblackpiece6, h, g);
                                        rowblackpiece6 = g;
                                        columnblackpiece6 = h;
                                        GridPane.setRowIndex(copy, copyrow);
                                        GridPane.setColumnIndex(copy, copycolumn);

                                        opposite = "black";

//        is.setColor(Color.RED);
//        r[GridPane.getRowIndex(imblackking)][GridPane.getColumnIndex(imblackking)].setEffect(borderGlow);
//      
// System.out.println("hassan");
//        root.add(imcheck,4,4);
//    
                                    } 
                                    if (checkblackqueen(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackpawn(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackcastle(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackbishops(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkfirst1(GridPane.getRowIndex(imwhiteking), GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking), 0) == true) {
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);

                                    }

                                } else if (name.equals("blackpawn8")) {
                                    t.setText("");

                                    int g = GridPane.getRowIndex(imblackpiece7);
                                    int h = GridPane.getColumnIndex(imblackpiece7);

                                    root.getChildren().remove(imblackpiece7);

                                    root.add(imblackpiece7, j, i);
                                    rowblackpiece7 = i;
                                    columnblackpiece7 = j;
                                    opposite = "white";
                                    ImageView copy = new ImageView();
                                    int copyrow = 0;
                                    int copycolumn = 0;
                                    for (int l = 0; l < whiteimages.size(); l++) {

                                        if ((GridPane.getRowIndex(whiteimages.get(l)) == i && GridPane.getColumnIndex(whiteimages.get(l)) == j)) {
                                            copy = whiteimages.get(l);
                                            copyrow = GridPane.getRowIndex(copy);
                                            copycolumn = GridPane.getColumnIndex(copy);
                                            whitecolumn.set(l, 10);
                                            whiterow.set(l, 10);
                                            GridPane.setColumnIndex(whiteimages.get(l), 10);
                                            GridPane.setRowIndex(whiteimages.get(l), 10);
                                            System.out.println(whitecolumn.get(l));
                                            System.out.println(whiterow.get(l));
//     
                                            //root.getChildren().remove(blackimages.get(l));
                                            break;
                                        }
                                    }

                                    if (checkwhitequeen(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitepawn(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitecastle(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitebishops(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkfirst(GridPane.getRowIndex(imblackking), GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking), 0) == true) {
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);
                                        root.getChildren().remove(imblackpiece7);
                                        root.add(imblackpiece7, h, g);
                                        rowblackpiece7 = g;
                                        columnblackpiece7 = h;
                                        GridPane.setRowIndex(copy, copyrow);
                                        GridPane.setColumnIndex(copy, copycolumn);

                                     
                                        opposite = "black";
//        is.setColor(Color.RED);
//        r[GridPane.getRowIndex(imblackking)][GridPane.getColumnIndex(imblackking)].setEffect(borderGlow);
//      
// System.out.println("hassan");
//        root.add(imcheck,4,4);
//    

                                    } 

                                    if (checkblackqueen(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackpawn(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackcastle(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackbishops(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkfirst1(GridPane.getRowIndex(imwhiteking), GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking), 0) == true) {
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);

                                    }

                                } else if (name.equals("whitecastle")) {
                                    t.setText("");

                                    int g = GridPane.getRowIndex(imgwhitecastle);
                                    int h = GridPane.getColumnIndex(imgwhitecastle);
                                    root.getChildren().remove(imgwhitecastle);

                                    root.add(imgwhitecastle, j, i);
                                    rowwhitecastle = i;
                                    columnwhitecastle = j;

                                    opposite = "black";
                                    if (checkwhitequeen(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitepawn(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitecastle(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitebishops(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkfirst(GridPane.getRowIndex(imblackking), GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking), 0) == true) {
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);

//        is.setColor(Color.RED);
//        r[GridPane.getRowIndex(imblackking)][GridPane.getColumnIndex(imblackking)].setEffect(borderGlow);
//      
// System.out.println("hassan");
//        root.add(imcheck,4,4);
//    
                                    }
                                    ImageView copy = new ImageView();
                                    int copyrow = 0;
                                    int copycolumn = 0;
                                    for (int l = 0; l < blackimages.size(); l++) {

                                        if ((GridPane.getRowIndex(blackimages.get(l)) == i && GridPane.getColumnIndex(blackimages.get(l)) == j)) {
                                            copy = blackimages.get(l);
                                            copyrow = GridPane.getRowIndex(copy);
                                            copycolumn = GridPane.getColumnIndex(copy);
                                            blackcolumn.set(l, 10);
                                            blackrow.set(l, 10);
                                            GridPane.setColumnIndex(blackimages.get(l), 10);
                                            GridPane.setRowIndex(blackimages.get(l), 10);
                                            System.out.println(blackcolumn.get(l));
                                            System.out.println(blackrow.get(l));
//     
                                            //root.getChildren().remove(blackimages.get(l));
                                            break;
                                        }
                                    }

                                    if (checkblackqueen(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackpawn(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackcastle(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackbishops(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkfirst1(GridPane.getRowIndex(imwhiteking), GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking), 0) == true) {
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);
                                        root.getChildren().remove(imgwhitecastle);
                                        root.add(imgwhitecastle, h, g);
                                        rowwhitecastle = g;
                                        columnwhitecastle = h;
                                        GridPane.setRowIndex(copy, copyrow);
                                        GridPane.setColumnIndex(copy, copycolumn);

                                        opposite = "white";

                                    }

                                } else if (name.equals("whitecastle1")) {
                                    t.setText("");

                                    int g = GridPane.getRowIndex(imgwhitecastle1);
                                    int h = GridPane.getColumnIndex(imgwhitecastle1);
                                    root.getChildren().remove(imgwhitecastle1);

                                    root.add(imgwhitecastle1, j, i);
                                    rowwhitecastle1 = i;
                                    columnwhitecastle1 = j;
                                    opposite = "black";
                                    if (checkwhitequeen(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitepawn(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitecastle(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitebishops(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkfirst(GridPane.getRowIndex(imblackking), GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking), 0) == true) {
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);

//        is.setColor(Color.RED);
//        r[GridPane.getRowIndex(imblackking)][GridPane.getColumnIndex(imblackking)].setEffect(borderGlow);
//      
// System.out.println("hassan");
//        root.add(imcheck,4,4);
//    
                                    }
                                    ImageView copy = new ImageView();
                                    int copyrow = 0;
                                    int copycolumn = 0;
                                    for (int l = 0; l < blackimages.size(); l++) {

                                        if ((GridPane.getRowIndex(blackimages.get(l)) == i && GridPane.getColumnIndex(blackimages.get(l)) == j)) {
                                            copy = blackimages.get(l);
                                            copyrow = GridPane.getRowIndex(copy);
                                            copycolumn = GridPane.getColumnIndex(copy);
                                            blackcolumn.set(l, 10);
                                            blackrow.set(l, 10);
                                            GridPane.setColumnIndex(blackimages.get(l), 10);
                                            GridPane.setRowIndex(blackimages.get(l), 10);
                                            System.out.println(blackcolumn.get(l));
                                            System.out.println(blackrow.get(l));
//     
                                            //root.getChildren().remove(blackimages.get(l));
                                            break;
                                        }
                                    }

                                    if (checkblackqueen(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackpawn(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackcastle(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackbishops(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkfirst1(GridPane.getRowIndex(imwhiteking), GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking), 0) == true) {
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);
                                        root.getChildren().remove(imgwhitecastle1);
                                        root.add(imgwhitecastle1, h, g);
                                        rowwhitecastle1 = g;
                                        columnwhitecastle1 = h;
                                        GridPane.setRowIndex(copy, copyrow);
                                        GridPane.setColumnIndex(copy, copycolumn);
                                        opposite = "white";

                                    }

                                } else if (name.equals("whitebishop")) {
                                    t.setText("");

                                    int g = GridPane.getRowIndex(imgwhitebishop);
                                    int h = GridPane.getColumnIndex(imgwhitebishop);

                                    root.getChildren().remove(imgwhitebishop);

                                    root.add(imgwhitebishop, j, i);
                                    rowwhitebishop = i;
                                    columnwhitebishop = j;
                                    opposite = "black";
                                    if (checkwhitequeen(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitepawn(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitecastle(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitebishops(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkfirst(GridPane.getRowIndex(imblackking), GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking), 0) == true) {
                                        System.out.println("hassan");
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);

//        is.setColor(Color.RED);
//        r[GridPane.getRowIndex(imblackking)][GridPane.getColumnIndex(imblackking)].setEffect(borderGlow);
//      
// System.out.println("hassan");
//        root.add(imcheck,4,4);
//    
                                    }
                                    ImageView copy = new ImageView();
                                    int copyrow = 0;
                                    int copycolumn = 0;
                                    for (int l = 0; l < blackimages.size(); l++) {

                                        if ((GridPane.getRowIndex(blackimages.get(l)) == i && GridPane.getColumnIndex(blackimages.get(l)) == j)) {
                                            copy = blackimages.get(l);
                                            copyrow = GridPane.getRowIndex(copy);
                                            copycolumn = GridPane.getColumnIndex(copy);
                                            blackcolumn.set(l, 10);
                                            blackrow.set(l, 10);
                                            GridPane.setColumnIndex(blackimages.get(l), 10);
                                            GridPane.setRowIndex(blackimages.get(l), 10);
                                            System.out.println(blackcolumn.get(l));
                                            System.out.println(blackrow.get(l));
//     
                                            //root.getChildren().remove(blackimages.get(l));
                                            break;
                                        }
                                    }

                                    if (checkblackqueen(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackpawn(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackcastle(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackbishops(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkfirst1(GridPane.getRowIndex(imwhiteking), GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking), 0) == true) {
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);
                                        root.getChildren().remove(imgwhitebishop);
                                        root.add(imgwhitebishop, h, g);
                                        rowwhitebishop = g;
                                        columnwhitebishop = h;
                                        GridPane.setRowIndex(copy, copyrow);
                                        GridPane.setColumnIndex(copy, copycolumn);
                                        opposite = "white";

                                    }

                                } else if (name.equals("whitebishop1")) {
                                    t.setText("");

                                    int g = GridPane.getRowIndex(imgwhitebishop1);
                                    int h = GridPane.getColumnIndex(imgwhitebishop1);

                                    root.getChildren().remove(imgwhitebishop1);

                                    root.add(imgwhitebishop1, j, i);
                                    rowwhitebishop1 = i;
                                    columnwhitebishop1 = j;
                                    opposite = "black";
                                    if ((checkwhitequeen(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true )|| (checkwhitepawn(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true )|| (checkwhitecastle(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true) || (checkwhitebishops(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true) ||( checkfirst(GridPane.getRowIndex(imblackking), GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking), 0) == true) ){
                                        System.out.println("crazy hassan");
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);

//        is.setColor(Color.RED);
//        r[GridPane.getRowIndex(imblackking)][GridPane.getColumnIndex(imblackking)].setEffect(borderGlow);
//      
// System.out.println("hassan");
//        root.add(imcheck,4,4);
//    
                                    }

                                    ImageView copy = new ImageView();
                                    int copyrow = 0;
                                    int copycolumn = 0;
                                    for (int l = 0; l < blackimages.size(); l++) {

                                        if ((GridPane.getRowIndex(blackimages.get(l)) == i && GridPane.getColumnIndex(blackimages.get(l)) == j)) {
                                            copy = blackimages.get(l);
                                            copyrow = GridPane.getRowIndex(copy);
                                            copycolumn = GridPane.getColumnIndex(copy);
                                            blackcolumn.set(l, 10);
                                            blackrow.set(l, 10);
                                            GridPane.setColumnIndex(blackimages.get(l), 10);
                                            GridPane.setRowIndex(blackimages.get(l), 10);
                                            System.out.println(blackcolumn.get(l));
                                            System.out.println(blackrow.get(l));
//     
                                            //root.getChildren().remove(blackimages.get(l));
                                            break;
                                        }
                                    }
                                    if (checkblackqueen(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackpawn(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackcastle(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackbishops(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkfirst1(GridPane.getRowIndex(imwhiteking), GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking), 0) == true) {
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);
                                        root.getChildren().remove(imgwhitebishop1);
                                        root.add(imgwhitebishop1, h, g);
                                        rowwhitebishop1 = g;
                                        columnwhitebishop1 = h;

                                        GridPane.setRowIndex(copy, copyrow);
                                        GridPane.setColumnIndex(copy, copycolumn);
                                        opposite = "white";

                                    }

                                } else if (name.equals("blackbishop")) {
                                    t.setText("");

                                    int g = GridPane.getRowIndex(imblackbishop);
                                    int h = GridPane.getColumnIndex(imblackbishop);

                                    root.getChildren().remove(imblackbishop);

                                    root.add(imblackbishop, j, i);
                                    blackbishoprow = i;
                                    blackbishopcolumn = j;
                                    opposite = "white";
                                    ImageView copy = new ImageView();
                                    int copyrow = 0;
                                    int copycolumn = 0;
                                    for (int l = 0; l < whiteimages.size(); l++) {

                                        if ((GridPane.getRowIndex(whiteimages.get(l)) == i && GridPane.getColumnIndex(whiteimages.get(l)) == j)) {
                                            copy = whiteimages.get(l);
                                            copyrow = GridPane.getRowIndex(copy);
                                            copycolumn = GridPane.getColumnIndex(copy);
                                            whitecolumn.set(l, 10);
                                            whiterow.set(l, 10);
                                            GridPane.setColumnIndex(whiteimages.get(l), 10);
                                            GridPane.setRowIndex(whiteimages.get(l), 10);
                                            System.out.println(whitecolumn.get(l));
                                            System.out.println(whiterow.get(l));
//     
                                            //root.getChildren().remove(blackimages.get(l));
                                            break;
                                        }
                                    }

                                    if (checkwhitequeen(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitepawn(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitecastle(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitebishops(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkfirst(GridPane.getRowIndex(imblackking), GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking), 0) == true) {
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);
                                        root.getChildren().remove(imblackbishop);
                                        root.add(imblackbishop, h, g);
                                        blackbishoprow = g;
                                        blackbishopcolumn = h;
                                        GridPane.setRowIndex(copy, copyrow);
                                        GridPane.setColumnIndex(copy, copycolumn);

                                        opposite = "black";

//        is.setColor(Color.RED);
//        r[GridPane.getRowIndex(imblackking)][GridPane.getColumnIndex(imblackking)].setEffect(borderGlow);
//      
// System.out.println("hassan");
//        root.add(imcheck,4,4);
//    
                                    }

                                    if (checkblackqueen(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackpawn(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackcastle(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackbishops(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkfirst1(GridPane.getRowIndex(imwhiteking), GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking), 0) == true) {
                                        System.out.println("crazyhassan");
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);

                                    }

                                } else if (name.equals("blackqueen")) {
                                    t.setText("");

                                    int g = GridPane.getRowIndex(imblackqueen);
                                    int h = GridPane.getColumnIndex(imblackqueen);
                                    root.getChildren().remove(imblackqueen);

                                    root.add(imblackqueen, j, i);
                                    blackqueenrow = i;
                                    blackqueencolumn = j;
                                    opposite = "white";
                                    ImageView copy = new ImageView();
                                    int copyrow = 0;
                                    int copycolumn = 0;
                                    for (int l = 0; l < whiteimages.size(); l++) {

                                        if ((GridPane.getRowIndex(whiteimages.get(l)) == i && GridPane.getColumnIndex(whiteimages.get(l)) == j)) {
                                            copy = whiteimages.get(l);
                                            copyrow = GridPane.getRowIndex(copy);
                                            copycolumn = GridPane.getColumnIndex(copy);
                                            whitecolumn.set(l, 10);
                                            whiterow.set(l, 10);
                                            GridPane.setColumnIndex(whiteimages.get(l), 10);
                                            GridPane.setRowIndex(whiteimages.get(l), 10);
                                            System.out.println(whitecolumn.get(l));
                                            System.out.println(whiterow.get(l));
//     
                                            //root.getChildren().remove(blackimages.get(l));
                                            break;
                                        }
                                    }

                                    if (checkwhitequeen(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitepawn(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitecastle(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitebishops(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkfirst(GridPane.getRowIndex(imblackking), GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking), 0) == true) {
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);
                                        root.getChildren().remove(imblackqueen);
                                        root.add(imblackqueen, h, g);
                                        blackqueenrow = g;
                                        blackqueencolumn = h;

                                        GridPane.setRowIndex(copy, copyrow);
                                        GridPane.setColumnIndex(copy, copycolumn);

                                        opposite = "black";

//        is.setColor(Color.RED);
//        r[GridPane.getRowIndex(imblackking)][GridPane.getColumnIndex(imblackking)].setEffect(borderGlow);
//      
// System.out.println("hassan");
//        root.add(imcheck,4,4);
//    
                                    }

                                    if (checkblackqueen(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackpawn(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackcastle(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackbishops(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkfirst1(GridPane.getRowIndex(imwhiteking), GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking), 0) == true) {
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);
                                    }

                                } else if (name.equals("whitequeen")) {
                                    t.setText("");

                                    int g = GridPane.getRowIndex(imwhitequeen);
                                    int h = GridPane.getColumnIndex(imwhitequeen);
                                    root.getChildren().remove(imwhitequeen);

                                    root.add(imwhitequeen, j, i);
                                    rowwhitequeen = i;
                                    columnwhitequeen = j;
                                    opposite = "black";
                                    if (checkwhitequeen(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitepawn(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitecastle(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitebishops(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkfirst(GridPane.getRowIndex(imblackking), GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking), 0) == true) {
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);
                                        //        is.setColor(Color.RED);
//        r[GridPane.getRowIndex(imblackking)][GridPane.getColumnIndex(imblackking)].setEffect(borderGlow);
//      
// System.out.println("hassan");
//        root.add(imcheck,4,4);
//    

                                    }
                                    ImageView copy = new ImageView();
                                    int copyrow = 0;
                                    int copycolumn = 0;
                                    for (int l = 0; l < blackimages.size(); l++) {

                                        if ((GridPane.getRowIndex(blackimages.get(l)) == i && GridPane.getColumnIndex(blackimages.get(l)) == j)) {
                                            copy = blackimages.get(l);
                                            copyrow = GridPane.getRowIndex(copy);
                                            copycolumn = GridPane.getColumnIndex(copy);
                                            blackcolumn.set(l, 10);
                                            blackrow.set(l, 10);
                                            GridPane.setColumnIndex(blackimages.get(l), 10);
                                            GridPane.setRowIndex(blackimages.get(l), 10);
                                            System.out.println(blackcolumn.get(l));
                                            System.out.println(blackrow.get(l));
//     
                                            //root.getChildren().remove(blackimages.get(l));
                                            break;
                                        }
                                    }

                                    if (checkblackqueen(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackpawn(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackcastle(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackbishops(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkfirst1(GridPane.getRowIndex(imwhiteking), GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking), 0) == true) {
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);
                                        root.getChildren().remove(imwhitequeen);
                                        root.add(imwhitequeen, h, g);
                                        rowwhitequeen = g;
                                        columnwhitequeen = h;

                                        GridPane.setRowIndex(copy, copyrow);
                                        GridPane.setColumnIndex(copy, copycolumn);
                                        opposite = "white";

                                    }

                                } else if (name.equals("blackcastle1")) {
                                    t.setText("");

                                    int g = GridPane.getRowIndex(img1);
                                    int h = GridPane.getColumnIndex(img1);
                                    root.getChildren().remove(img1);

                                    root.add(img1, j, i);
                                    blackcastlerow = i;
                                    blackcastle1column = j;
                                    opposite = "white";
                                    ImageView copy = new ImageView();
                                    int copyrow = 0;
                                    int copycolumn = 0;
                                    for (int l = 0; l < whiteimages.size(); l++) {

                                        if ((GridPane.getRowIndex(whiteimages.get(l)) == i && GridPane.getColumnIndex(whiteimages.get(l)) == j)) {
                                            copy = whiteimages.get(l);
                                            copyrow = GridPane.getRowIndex(copy);
                                            copycolumn = GridPane.getColumnIndex(copy);
                                            whitecolumn.set(l, 10);
                                            whiterow.set(l, 10);
                                            GridPane.setColumnIndex(whiteimages.get(l), 10);
                                            GridPane.setRowIndex(whiteimages.get(l), 10);
                                            System.out.println(whitecolumn.get(l));
                                            System.out.println(whiterow.get(l));
//     
                                            //root.getChildren().remove(blackimages.get(l));
                                            break;
                                        }
                                    }

                                    if (checkwhitequeen(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitepawn(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitecastle(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitebishops(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkfirst(GridPane.getRowIndex(imblackking), GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking), 0) == true) {
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);
                                        root.getChildren().remove(img1);
                                        root.add(img1, h, g);
                                        blackcastlerow = g;
                                        blackcastle1column = h;
                                        GridPane.setRowIndex(copy, copyrow);
                                        GridPane.setColumnIndex(copy, copycolumn);
                                        opposite = "black";

//        is.setColor(Color.RED);
//        r[GridPane.getRowIndex(imblackking)][GridPane.getColumnIndex(imblackking)].setEffect(borderGlow);
//      
// System.out.println("hassan");
//        root.add(imcheck,4,4);
//    
                                    }

                                    if (checkblackqueen(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackpawn(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackcastle(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackbishops(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkfirst1(GridPane.getRowIndex(imwhiteking), GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking), 0) == true) {
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);

                                    }

                                } else if (name.equals("blackbishop1")) {
                                    t.setText("");

                                    int g = GridPane.getRowIndex(imblackbishop1);
                                    int h = GridPane.getColumnIndex(imblackbishop1);
                                    root.getChildren().remove(imblackbishop1);

                                    root.add(imblackbishop1, j, i);
                                    blackbishoprow1 = i;
                                    blackbishopcolumn1 = j;
                                    opposite = "white";
                                    ImageView copy = new ImageView();
                                    int copyrow = 0;
                                    int copycolumn = 0;
                                    for (int l = 0; l < whiteimages.size(); l++) {

                                        if ((GridPane.getRowIndex(whiteimages.get(l)) == i && GridPane.getColumnIndex(whiteimages.get(l)) == j)) {
                                            copy = whiteimages.get(l);
                                            copyrow = GridPane.getRowIndex(copy);
                                            copycolumn = GridPane.getColumnIndex(copy);
                                            whitecolumn.set(l, 10);
                                            whiterow.set(l, 10);
                                            GridPane.setColumnIndex(whiteimages.get(l), 10);
                                            GridPane.setRowIndex(whiteimages.get(l), 10);
                                            System.out.println(whitecolumn.get(l));
                                            System.out.println(whiterow.get(l));
//     
                                            //root.getChildren().remove(blackimages.get(l));
                                            break;
                                        }
                                    }

                                    if (checkwhitequeen(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitepawn(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitecastle(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkwhitebishops(GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking)) == true || checkfirst(GridPane.getRowIndex(imblackking), GridPane.getRowIndex(imblackking), GridPane.getColumnIndex(imblackking), 0) == true) {
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);
                                        root.getChildren().remove(imblackbishop1);
                                        root.add(imblackbishop1, h, g);
                                        blackbishoprow1 = g;
                                        blackbishopcolumn1 = h;
                                        GridPane.setRowIndex(copy, copyrow);
                                        GridPane.setColumnIndex(copy, copycolumn);
                                        opposite = "black";

//        is.setColor(Color.RED);
//        r[GridPane.getRowIndex(imblackking)][GridPane.getColumnIndex(imblackking)].setEffect(borderGlow);
//      
// System.out.println("hassan");
//        root.add(imcheck,4,4);
//    
                                    }

                                    if (checkblackqueen(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackpawn(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackcastle(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkblackbishops(GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking)) == true || checkfirst1(GridPane.getRowIndex(imwhiteking), GridPane.getRowIndex(imwhiteking), GridPane.getColumnIndex(imwhiteking), 0) == true) {
                                        System.out.println("crazy hassan");
                                        t.setText("Checked");
                                        // t.setX(300);
                                        //t.setY(150);
                                        t.setFont(Font.font(20));
                                        t.setFill(Color.RED);
                                        t.setStroke(Color.RED);
                                        t.setStrokeWidth(2);

                                    }

                                } else if (name.equals("blackking")) {
                                    t.setText("");
                                    for (int l = 0; l < blackimages.size(); l++) {

                                        if ((GridPane.getRowIndex(whiteimages.get(l)) == i && GridPane.getColumnIndex(whiteimages.get(l)) == j)) {
                                            whitecolumn.set(l, 10);
                                            whiterow.set(l, 10);
                                            GridPane.setColumnIndex(whiteimages.get(l), 10);
                                            GridPane.setRowIndex(whiteimages.get(l), 10);

                                            System.out.println(whitecolumn.get(l));
                                            System.out.println(whiterow.get(l));
//     
                                            //root.getChildren().remove(whiteimages.get(l));
                                            break;
                                        }
                                    }
                                    root.getChildren().remove(imblackking);

                                    root.add(imblackking, j, i);
                                    blackkingrow = i;
                                    blackkingcolumn = j;

                                    opposite = "white";

                                } else if (name.equals("whiteking")) {
                                    t.setText("");
                                    for (int l = 0; l < blackimages.size(); l++) {

                                        if ((GridPane.getRowIndex(blackimages.get(l)) == i && GridPane.getColumnIndex(blackimages.get(l)) == j)) {
                                            blackcolumn.set(l, 10);
                                            blackrow.set(l, 10);
                                            GridPane.setColumnIndex(blackimages.get(l), 10);
                                            GridPane.setRowIndex(blackimages.get(l), 10);

                                            System.out.println(blackcolumn.get(l));
                                            System.out.println(blackrow.get(l));
//     
                                            //root.getChildren().remove(blackimages.get(l));
                                            break;
                                        }
                                    }
                                    root.getChildren().remove(imwhiteking);

                                    root.add(imwhiteking, j, i);
                                    whitekingrow = i;
                                    whitekingcolumn = j;
                                    opposite = "black";

                                }

//    if(r[1][0].getEffect()!=10){
//r[1][0].setEffect(10);
//    }
                                clear();
                                root.getChildren().remove(imcheck);
                            }

                            //}
                        }
                    }
                }

            }
        });

        Scene scene = new Scene(root, 560, 560);

        primaryStage.setTitle("Chess");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void clear() {
        for (int k = 0; k < ra.length; k++) {
            for (int l = 0; l < ra[k].length; l++) {
                ra[k][l].setEffect(null);
            }
        }
    }

    public boolean checkfirst(int hdown, int row1, int column1, int l) {
        l = l * -1;
//             for (int i = 0; i < r.length; i++) {
//                    for (int j = 0; j < r[i].length; j++) {
//                               
        for (int k = 2; k <= 2; k++) {
            for (int i = 0; i < whitehorses.size(); i++) {
                if (GridPane.getRowIndex(whitehorses.get(i)) == hdown - 1 && GridPane.getColumnIndex(whitehorses.get(i)) == column1 - 2 && hdown - 1 >= 0 && column1 - 2 >= 0) {
                    //                   root.add(imcheck,0,4);
                    //System.out.println("whitehorse rona1");
                    return true;
                }

                if (GridPane.getRowIndex(whitehorses.get(i)) == hdown + 1 && GridPane.getColumnIndex(whitehorses.get(i)) == column1 - 2 && hdown + 1 <= 7 && column1 - 2 >= 0) {
                    //root.add(imcheck,0,4);
                    //System.out.println("whitehorse rona2");
                    return true;
                }
                if (GridPane.getRowIndex(whitehorses.get(i)) == hdown - 1 && GridPane.getColumnIndex(whitehorses.get(i)) == column1 + 2 && hdown - 1 >= 0 && column1 - 2 >= 0) {
                    //root.add(imcheck,0,4);
                     // System.out.println("whitehorse rona3");
                    return true;
                }

                if (GridPane.getRowIndex(whitehorses.get(i)) == hdown + 1 && GridPane.getColumnIndex(whitehorses.get(i)) == column1 + 2 && hdown + 1 <= 7 && column1 + 2 <= 7) {
                    //root.add(imcheck,0,4);
                      //System.out.println("whitehorse rona4");
                    return true;
                }
                if (GridPane.getRowIndex(whitehorses.get(i)) == hdown - k && GridPane.getColumnIndex(whitehorses.get(i)) == column1 - 1 && hdown - k >= 0 && column1 - 1 >= 0) {
                    //                   root.add(imcheck,0,4);
                     // System.out.println("whitehorse rona5");
                    return true;
                }

                if (GridPane.getRowIndex(whitehorses.get(i)) == hdown + k && GridPane.getColumnIndex(whitehorses.get(i)) == column1 - 1 && hdown + k <= 7 && column1 - 1 >= 0) {
                    //root.add(imcheck,0,4);
                      //System.out.println("whitehorse rona6");
                    return true;
                }
                if (GridPane.getRowIndex(whitehorses.get(i)) == hdown - k && GridPane.getColumnIndex(whitehorses.get(i)) == column1 + 1 && hdown - k >= 0 && column1 - 1 >= 0) {
                    //root.add(imcheck,0,4);
                      //System.out.println("whitehorse rona7");
                    return true;
                }

                if (GridPane.getRowIndex(whitehorses.get(i)) == hdown + k && GridPane.getColumnIndex(whitehorses.get(i)) == column1 + 1 && hdown + k <= 1 && column1 + 1 <= 7) {
                    //root.add(imcheck,0,4);
                //      System.out.println("whitehorse rona8");
                    return true;
                }
            }

        }
//                               }
//                        
//                        }
  //System.out.println("whitehorse nahi rona");     
return false;
    }

    public boolean checkwhitecastle(int row, int column) {
        for (int k = 0; k < whitecastles.size(); k++) {
            for (int i = 1; i <= 7; i++) {

                if (GridPane.getRowIndex(whitecastles.get(k)) == row && GridPane.getColumnIndex(whitecastles.get(k)) == column + i && column + i <= 7) {

                    for (int j = column + i - 1; j >= column + 1; j--) {
                        for (int y = 0; y < whiteimages.size(); y++) {
                            if (blackimages.get(y)!=imblackking&&(GridPane.getRowIndex(whiteimages.get(y)) == row && GridPane.getColumnIndex(whiteimages.get(y)) == j) || (GridPane.getRowIndex(blackimages.get(y)) == row && GridPane.getColumnIndex(blackimages.get(y)) == j) && j >= 0) {
  //System.out.println("whitecastle nahi rona");
                                return false;
                            }

                        }
                    }
    //                  System.out.println("whitecastle rona");
                    return true;
                }
//                                           else
//                                           {
//                                               //System.out.println("hassan");
//                                           for(int j=0;j<whiteimages.size();j++)
//                                           {                                          if(GridPane.getRowIndex(whiteimages.get(j))==row&&GridPane.getColumnIndex(whiteimages.get(j))==column+i||(GridPane.getRowIndex(blackimages.get(j))==row&&GridPane.getColumnIndex(blackimages.get(j))==column+i)&&column+i<=7)
//                                           {
//                                               //System.out.println("ahmad");
//       return false;
//}
//                                               
//                                              }
//                                             }
//        
//        
//        
                if (GridPane.getRowIndex(whitecastles.get(k)) == row && GridPane.getColumnIndex(whitecastles.get(k)) == column - i && column - i >= 0) {
                    for (int j = column - i + 1; j <= column - 1; j++) {
                        for (int y = 0; y < whiteimages.size(); y++) {
                            if (blackimages.get(y)!=imblackking&&(GridPane.getRowIndex(whiteimages.get(y)) == row && GridPane.getColumnIndex(whiteimages.get(y)) == j) ||( GridPane.getRowIndex(blackimages.get(y)) == row && GridPane.getColumnIndex(blackimages.get(y)) == j) && j <= 7) {
//                                System.out.println("hassan");
  //System.out.println("whitecastle nahi rona");  
return false;
                            }

                        }
                    }
    //                  System.out.println("whitecastle rona");
                    return true;
                }
//                                                    else
//                                           {
//                                           for(int j=0;j<whiteimages.size();j++)
//                                           {                                          if(GridPane.getRowIndex(whiteimages.get(j))==row&&GridPane.getColumnIndex(whiteimages.get(j))==column-i||(GridPane.getRowIndex(blackimages.get(j))==row&&GridPane.getColumnIndex(blackimages.get(j))==column-i)&&column-i>=0)
//                                           { 
//                                              //   System.out.println("ahmad");
//       return false;
//}
//                                           }}
                if (GridPane.getColumnIndex(whitecastles.get(k)) == column && GridPane.getRowIndex(whitecastles.get(k)) == row + i && row + i <= 7) {

                    for (int j = row + i - 1; j >= row + 1; j--) {
                        for (int y = 0; y < whiteimages.size(); y++) {
                            if (blackimages.get(y)!=imblackking&&(GridPane.getRowIndex(whiteimages.get(y)) == j && GridPane.getColumnIndex(whiteimages.get(y)) == column )|| (GridPane.getRowIndex(blackimages.get(y)) == j && GridPane.getColumnIndex(blackimages.get(y)) == column )&& j >= 0) {
//                                System.out.println("hassan");
  //System.out.println("whitecastle nahi rona");  
return false;
                            }

                        }
                    }
                    //  System.out.println("ahmad");
  //System.out.println("whitecastle rona");
                    return true;
                }
//                else
//                                           {
//                                           for(int j=0;j<whiteimages.size();j++)
//                                           {                                          if(GridPane.getRowIndex(whiteimages.get(j))==row+i&&GridPane.getColumnIndex(whiteimages.get(j))==column||(GridPane.getRowIndex(blackimages.get(j))==row+i&&GridPane.getColumnIndex(blackimages.get(j))==column)&&row+i<=7)
//                                           { 
//                                            //     System.out.println("ahmad");
//       return false;
//}
//                                           }}
//        
                if (GridPane.getColumnIndex(whitecastles.get(k)) == column && GridPane.getRowIndex(whitecastles.get(k)) == row - i && row - i >= 0) {
                    for (int j = row - i + 1; j <= row - 1; j++) {
                        for (int y = 0; y < whiteimages.size(); y++) {
                            if (blackimages.get(y)!=imblackking&&(GridPane.getRowIndex(whiteimages.get(y)) == j && GridPane.getColumnIndex(whiteimages.get(y)) == column) || (GridPane.getRowIndex(blackimages.get(y)) == j && GridPane.getColumnIndex(blackimages.get(y)) == column )&& j <= 7) {
  //System.out.println("whitecastle nahi  rona");
                                return false;
                            }

                        }
                    }
  //System.out.println("whitecastle rona");
                    return true;
                }
//                    else
//                                           {
//                                           for(int j=0;j<whiteimages.size();j++)
//                                           {                                          if(GridPane.getRowIndex(whiteimages.get(j))==row-i&&GridPane.getColumnIndex(whiteimages.get(j))==column||(GridPane.getRowIndex(blackimages.get(j))==row-i&&GridPane.getColumnIndex(blackimages.get(j))==column)&&row-i>=0)
//                                           { 
//                                               return false;
//}
//                                           }}
//     
//        

            }

        }
  //System.out.println("whitecastle nahi rona");
        return false;
    }

    public boolean checkwhitepawn(int row, int column) {
        for (int i = 0; i < whitepawns.size(); i++) {
            for (int j = 1; j <= 1; j++) {
                if (GridPane.getRowIndex(whitepawns.get(i)) == row - 1 && GridPane.getColumnIndex(whitepawns.get(i)) == column - j && column - j >= 0 && row + 1 >= 0) {
    //                System.out.println("whitepawn rona");
                    return true;
                }
                if (GridPane.getRowIndex(whitepawns.get(i)) == row - 1 && GridPane.getColumnIndex(whitepawns.get(i)) == column + j && column + j <= 7 && row + 1 >= 0) {
      //              System.out.println("whitepawn rona");
                    
                    return true;
                }
            }
        }
//System.out.println("whitepawn nahi rona");
                    
        return false;
    }

    public boolean checkwhitebishops(int row, int column) {
        for (int i = 0; i < whitebishops.size(); i++) {
            for (int j = 1; j <= 7; j++) {
                if (GridPane.getRowIndex(whitebishops.get(i)) == row - j && GridPane.getColumnIndex(whitebishops.get(i)) == column - j && column - j >= 0 && row - j >= 0) {
                    for (int t = row - j + 1, k = column - j + 1; t <= row - 1 || k <= column - 1; t++, k++) {
                        for (int y = 0; y < whiteimages.size(); y++) {
                          if ((GridPane.getRowIndex(whiteimages.get(y)) == t && GridPane.getColumnIndex(whiteimages.get(y)) == k) || (GridPane.getRowIndex(blackimages.get(y)) == t && GridPane.getColumnIndex(blackimages.get(y)) == k) && j <= 7) {
                            if ((GridPane.getRowIndex(blackimages.get(y)) == GridPane.getRowIndex(imblackking) && GridPane.getColumnIndex(blackimages.get(y)) == GridPane.getColumnIndex(imblackking))||(whiteimages.get(y)==whitebishops.get(i))) {
                                System.out.println("heheheeheheehe1");
                                return true;
                            } else {
                                System.out.println(":P1");
                                return false;
                            }
                        }
                           if(t==row&&k==column)
                          {return true;}
                        
                        }
                    }

                    return true;
                }
                if (GridPane.getRowIndex(whitebishops.get(i)) == row - j && GridPane.getColumnIndex(whitebishops.get(i)) == column + j && column + j <= 7 && row - j >= 0) {
                    for (int t = row - j + 1, k = column + j - 1; t <= row - 1 || k <= column + 1||t>=0; t++, k--) {
                        for (int y = 0; y < whiteimages.size(); y++) {
                          if ((GridPane.getRowIndex(whiteimages.get(y)) == t && GridPane.getColumnIndex(whiteimages.get(y)) == k) || (GridPane.getRowIndex(blackimages.get(y)) == t && GridPane.getColumnIndex(blackimages.get(y)) == k) && j <= 7) {
                            if ((GridPane.getRowIndex(blackimages.get(y)) == GridPane.getRowIndex(imblackking) && GridPane.getColumnIndex(blackimages.get(y)) == GridPane.getColumnIndex(imblackking))||(whiteimages.get(y)==whitebishops.get(i))) {
                                System.out.println("heheheeheheehe2");
                                return true;
                            } else {
                                System.out.println(":P2");
                                return false;
                            }
                        }
                          if(t==row&&k==column)
                          {return true;}
                        }
                    }
                    return true;
                }

                if (GridPane.getRowIndex(whitebishops.get(i)) == row + j && GridPane.getColumnIndex(whitebishops.get(i)) == column - j && column - j >= 0 && row + j <= 7) {
                    for (int t = row + j - 1, k = column - j + 1; t <= row + 1 || k <= column - 1||t>=0; t--, k++) {
                        for (int y = 0; y < whiteimages.size(); y++) {
                          if ((GridPane.getRowIndex(whiteimages.get(y)) == t && GridPane.getColumnIndex(whiteimages.get(y)) == k) || (GridPane.getRowIndex(blackimages.get(y)) == t && GridPane.getColumnIndex(blackimages.get(y)) == k) && j <= 7) {
                            if ((GridPane.getRowIndex(blackimages.get(y)) == GridPane.getRowIndex(imblackking) && GridPane.getColumnIndex(blackimages.get(y)) == GridPane.getColumnIndex(imblackking))||(whiteimages.get(y)==whitebishops.get(i))) {
                                System.out.println("heheheeheheehe3");
                                return true;
                            } else {
                                System.out.println(":P3");
                                return false;
                            }
                        }
                             if(t==row&&k==column)
                          {return true;}
                        }
                    }
                    return true;
                }
                if (GridPane.getRowIndex(whitebishops.get(i)) == row + j && GridPane.getColumnIndex(whitebishops.get(i)) == column + j && column + j <= 7 && row + j <= 7) {
                    for (int t = row + j - 1, k = column + j - 1; t <= row + 1 || k <= column + 1||t>=0; t--, k--) {
                        for (int y = 0; y < whiteimages.size(); y++) {
                          if ((GridPane.getRowIndex(whiteimages.get(y)) == t && GridPane.getColumnIndex(whiteimages.get(y)) == k) || (GridPane.getRowIndex(blackimages.get(y)) == t && GridPane.getColumnIndex(blackimages.get(y)) == k) && j <= 7) {
                            if ((GridPane.getRowIndex(blackimages.get(y)) == GridPane.getRowIndex(imblackking) && GridPane.getColumnIndex(blackimages.get(y)) == GridPane.getColumnIndex(imblackking))||(whiteimages.get(y)==whitebishops.get(i))) {
                                System.out.println("heheheeheheehe4");
                                return true;
                            } else {
                                System.out.println(":P4");
                                return false;
                            }
                        }
                             if(t==row&&k==column)
                          {return true;}
                        }
                    }
                    return true;
                }
            }
        }

        return false;
    }
 public boolean checkwhitequeen(int row, int column) {
        for (int j = 1; j <= 7; j++) {
            if (GridPane.getRowIndex(imwhitequeen) == row - j && GridPane.getColumnIndex(imwhitequeen) == column - j && column - j >= 0 && row - j >= 0) {
                int count=0;
                for (int t = row - j + 1, k = column - j + 1; t <= row - 1 || k <= column - 1||t>=0; t++, k++,count++) {
                    if(count==20)
                    {break;}
                    for (int y = 0; y < whiteimages.size(); y++) {
   if ((GridPane.getRowIndex(whiteimages.get(y)) == t && GridPane.getColumnIndex(whiteimages.get(y)) == k) || (GridPane.getRowIndex(blackimages.get(y)) == t && GridPane.getColumnIndex(blackimages.get(y)) == k) && j <= 7) {
                            if ((GridPane.getRowIndex(blackimages.get(y)) == GridPane.getRowIndex(imblackking) && GridPane.getColumnIndex(blackimages.get(y)) == GridPane.getColumnIndex(imblackking))) {
  //                            System.out.println("2");
                      return true;
                            } else {
    //                           System.out.println("3");
                                return false;
                            }
                        }
      if(t==row&&k==column)
                          {return true;}

                    }
                }
 //System.out.println("4");
                return true;
            }
            if (GridPane.getRowIndex(imwhitequeen) == row - j && GridPane.getColumnIndex(imwhitequeen) == column + j && column + j <= 7 && row - j >= 0) {
      //          System.out.println("5");
               int count=0;
                for (int t = row - j + 1, k = column + j - 1; t <= row - 1 || k <= column + 1||t>=0; t++, k--,count++) {
                 if(count==20)
                    {break;}
                    for (int y = 0; y < whiteimages.size(); y++) {
                        if ((GridPane.getRowIndex(whiteimages.get(y)) == t && GridPane.getColumnIndex(whiteimages.get(y)) == k) || (GridPane.getRowIndex(blackimages.get(y)) == t && GridPane.getColumnIndex(blackimages.get(y)) == k) && j <= 7) {
                            if ((GridPane.getRowIndex(blackimages.get(y)) == GridPane.getRowIndex(imblackking) && GridPane.getColumnIndex(blackimages.get(y)) == GridPane.getColumnIndex(imblackking))) {
                                 System.out.println("7");
                                 return true;
                            } else {
                                 System.out.println("8");
                                 return false;
                            }
                        }
                           if(t==row&&k==column)
                          {return true;}

                    }
                }
                 System.out.println("9");
                return true;
            }

            if (GridPane.getRowIndex(imwhitequeen) == row + j && GridPane.getColumnIndex(imwhitequeen) == column - j && column - j >= 0 && row + j <= 7) {
                System.out.println("10");
              int count=0;
                for (int t = row + j - 1, k = column - j + 1; t <= row + 1 || k <= column - 1||t>=0;count++, t--, k++) {
                    System.out.println("11");
                   if(count==20)
                    {break;}
                    for (int y = 0; y < whiteimages.size(); y++) {
                        if ((GridPane.getRowIndex(whiteimages.get(y)) == t && GridPane.getColumnIndex(whiteimages.get(y)) == k) || (GridPane.getRowIndex(blackimages.get(y)) == t && GridPane.getColumnIndex(blackimages.get(y)) == k) && j <= 7) {
                            if ((GridPane.getRowIndex(blackimages.get(y)) == GridPane.getRowIndex(imblackking) && GridPane.getColumnIndex(blackimages.get(y)) == GridPane.getColumnIndex(imblackking))) {
                                System.out.println("12");
                                return true;
                            } else {
                                 System.out.println("13");return false;
                            }
                        }
                           if(t==row&&k==column)
                          {return true;}
                    }
                }
                System.out.println("14");
                return true;
            }
            if (GridPane.getRowIndex(imwhitequeen) == row + j && GridPane.getColumnIndex(imwhitequeen) == column + j && column + j <= 7 && row + j <= 7) {
                System.out.println("15");
                int count=0;
                for (int t = row + j - 1, k = column + j - 1; t <= row + 1 || k <= column + 1||t>0; t--, k--,count++) {
                    System.out.println("16");
                    if(count==20)
                    {break;}
                    for (int y = 0; y < whiteimages.size(); y++) {
                        if ((GridPane.getRowIndex(whiteimages.get(y)) == t && GridPane.getColumnIndex(whiteimages.get(y)) == k) || (GridPane.getRowIndex(blackimages.get(y)) == t && GridPane.getColumnIndex(blackimages.get(y)) == k) && j <= 7) {
                            if ((GridPane.getRowIndex(blackimages.get(y)) == GridPane.getRowIndex(imblackking) && GridPane.getColumnIndex(blackimages.get(y)) == GridPane.getColumnIndex(imblackking))) {
                                 System.out.println("17");
                                return true;
                            } else {
                               System.out.println("18");
                                return false;
                            }
                        }
                           if(t==row&&k==column)
                          {return true;}
                    }
                }
                 System.out.println("19");
                return true;
            }
            if (GridPane.getRowIndex(imwhitequeen) == row && GridPane.getColumnIndex(imwhitequeen) == column + j && column + j <= 7) {
                for (int q = column + j - 1; q >= column + 1; q--) {
                    for (int y = 0; y < whiteimages.size(); y++) {
                        if (blackimages.get(y)!=imblackking&&(GridPane.getRowIndex(whiteimages.get(y)) == row && GridPane.getColumnIndex(whiteimages.get(y)) == q )|| (GridPane.getRowIndex(blackimages.get(y)) == row && GridPane.getColumnIndex(blackimages.get(y)) == q) && q >= 0) {
// System.out.println("whitequeen nahi rona");
                            return false;
                        }

                    }
                }
  //               System.out.println("whitequeen rona");
                return true;
            }

            if (GridPane.getRowIndex(imwhitequeen) == row && GridPane.getColumnIndex(imwhitequeen) == column - j && column - j >= 0) {
                for (int q = column - j + 1; q <= column - 1; q++) {
                    for (int y = 0; y < whiteimages.size(); y++) {
                        if (blackimages.get(y)!=imblackking&&(GridPane.getRowIndex(whiteimages.get(y)) == row && GridPane.getColumnIndex(whiteimages.get(y)) == q )|| (GridPane.getRowIndex(blackimages.get(y)) == row && GridPane.getColumnIndex(blackimages.get(y)) == q )&& q <= 7) {
    //                        System.out.println("whitequeen nahi rona");
                            return false;
                        }

                    }
                }
      //           System.out.println("whitequeen rona");
                return true;
            }

            if (GridPane.getColumnIndex(imwhitequeen) == column && GridPane.getRowIndex(imwhitequeen) == row + j && row + j <= 7) {
                for (int q = row + j - 1; q >= row + 1; q--) {
                    for (int y = 0; y < whiteimages.size(); y++) {
                        if (blackimages.get(y)!=imblackking&&(GridPane.getRowIndex(whiteimages.get(y)) == q && GridPane.getColumnIndex(whiteimages.get(y)) == column) || (GridPane.getRowIndex(blackimages.get(y)) == q && GridPane.getColumnIndex(blackimages.get(y)) == column) && q >= 0) {
        //                 System.out.println("whitequeen nahi rona");
                            return false;
                        }

                    }
                }
          //       System.out.println("whitequeen rona");
                return true;
            }

            if (GridPane.getColumnIndex(imwhitequeen) == column && GridPane.getRowIndex(imwhitequeen) == row - j && row - j >= 0) {
                for (int q = row - j + 1; q <= row - 1; q++) {
                    for (int y = 0; y < whiteimages.size(); y++) {
                        if (blackimages.get(y)!=imblackking&&(GridPane.getRowIndex(whiteimages.get(y)) == q && GridPane.getColumnIndex(whiteimages.get(y)) == column) || (GridPane.getRowIndex(blackimages.get(y)) == q && GridPane.getColumnIndex(blackimages.get(y)) == column) && q <= 7) {
 //System.out.println("whitequeen nahi rona");
                            return false;
                        }

                    }
                }
   //              System.out.println("whitequeen rona");
                return true;
            }
        }
 //System.out.println("whitequeen nahi rona");
        return false;
    }

//    public boolean checkwhitequeen(int row, int column) {
//        for (int j = 1; j <= 7; j++) {
//            if (GridPane.getRowIndex(imwhitequeen) == row - j && GridPane.getColumnIndex(imwhitequeen) == column - j && column - j >= 0 && row - j >= 0) {
//                for (int t = row - j + 1, k = column - j + 1; t <= row - 1 || k <= column - 1; t++, k++) {
//                    for (int y = 0; y < whiteimages.size(); y++) {
//   if ((GridPane.getRowIndex(whiteimages.get(y)) == t && GridPane.getColumnIndex(whiteimages.get(y)) == k) || (GridPane.getRowIndex(blackimages.get(y)) == t && GridPane.getColumnIndex(blackimages.get(y)) == k) && j <= 7) {
//                            if ((GridPane.getRowIndex(blackimages.get(y)) == GridPane.getRowIndex(imblackking) && GridPane.getColumnIndex(blackimages.get(y)) == GridPane.getColumnIndex(imblackking))) {
//                              System.out.println("whitequeen rona");
//                      return true;
//                            } else {
//                               System.out.println("whitequeen nahi rona");
//                                return false;
//                            }
//                        }
//
//                    }
//                }
// System.out.println("whitequeen rona");
//                return true;
//            }
//            if (GridPane.getRowIndex(imwhitequeen) == row - j && GridPane.getColumnIndex(imwhitequeen) == column + j && column + j <= 7 && row - j >= 0) {
//                for (int t = row - j + 1, k = column + j - 1; t <= row - 1 || k <= column + 1; t++, k--) {
//                    for (int y = 0; y < whiteimages.size(); y++) {
//                        if ((GridPane.getRowIndex(whiteimages.get(y)) == t && GridPane.getColumnIndex(whiteimages.get(y)) == k) || (GridPane.getRowIndex(blackimages.get(y)) == t && GridPane.getColumnIndex(blackimages.get(y)) == k) && j <= 7) {
//                            if ((GridPane.getRowIndex(blackimages.get(y)) == GridPane.getRowIndex(imblackking) && GridPane.getColumnIndex(blackimages.get(y)) == GridPane.getColumnIndex(imblackking))) {
//                                 System.out.println("whitequeen rona");
//                                 return true;
//                            } else {
//                                 System.out.println("whitequeen nahi rona");
//                                 return false;
//                            }
//                        }
//
//                    }
//                }
//                 System.out.println("whitequeen rona");
//                return true;
//            }
//
//            if (GridPane.getRowIndex(imwhitequeen) == row + j && GridPane.getColumnIndex(imwhitequeen) == column - j && column - j >= 0 && row + j <= 7) {
//                for (int t = row + j - 1, k = column - j + 1; t <= row + 1 || k <= column - 1; t--, k++) {
//                    for (int y = 0; y < whiteimages.size(); y++) {
//                        if ((GridPane.getRowIndex(whiteimages.get(y)) == t && GridPane.getColumnIndex(whiteimages.get(y)) == k) || (GridPane.getRowIndex(blackimages.get(y)) == t && GridPane.getColumnIndex(blackimages.get(y)) == k) && j <= 7) {
//                            if ((GridPane.getRowIndex(blackimages.get(y)) == GridPane.getRowIndex(imblackking) && GridPane.getColumnIndex(blackimages.get(y)) == GridPane.getColumnIndex(imblackking))) {
//                                System.out.println("whitequeen rona");
//                                return true;
//                            } else {
//                                 System.out.println("whitequeen nahi rona");return false;
//                            }
//                        }
//                    }
//                }
//                return true;
//            }
//            if (GridPane.getRowIndex(imwhitequeen) == row + j && GridPane.getColumnIndex(imwhitequeen) == column + j && column + j <= 7 && row + j <= 7) {
//                for (int t = row + j - 1, k = column + j - 1; t <= row + 1 || k <= column + 1; t--, k--) {
//                    for (int y = 0; y < whiteimages.size(); y++) {
//                        if ((GridPane.getRowIndex(whiteimages.get(y)) == t && GridPane.getColumnIndex(whiteimages.get(y)) == k) || (GridPane.getRowIndex(blackimages.get(y)) == t && GridPane.getColumnIndex(blackimages.get(y)) == k) && j <= 7) {
//                            if ((GridPane.getRowIndex(blackimages.get(y)) == GridPane.getRowIndex(imblackking) && GridPane.getColumnIndex(blackimages.get(y)) == GridPane.getColumnIndex(imblackking))) {
//                                 System.out.println("whitequeen rona");
//                                return true;
//                            } else {
//                               System.out.println("whitequeen nahi rona");
//                                return false;
//                            }
//                        }
//                    }
//                }
//                 System.out.println("whitequeen rona");
//                return true;
//            }
//            if (GridPane.getRowIndex(imwhitequeen) == row && GridPane.getColumnIndex(imwhitequeen) == column + j && column + j <= 7) {
//                for (int q = column + j - 1; q >= column + 1; q--) {
//                    for (int y = 0; y < whiteimages.size(); y++) {
//                        if (blackimages.get(y)!=imblackking&&(GridPane.getRowIndex(whiteimages.get(y)) == row && GridPane.getColumnIndex(whiteimages.get(y)) == q) ||( GridPane.getRowIndex(blackimages.get(y)) == row && GridPane.getColumnIndex(blackimages.get(y)) == q) && q >= 0) {
// System.out.println("whitequeen nahi rona");
//                            return false;
//                        }
//
//                    }
//                }
//                 System.out.println("whitequeen rona");
//                return true;
//            }
//
//            if (GridPane.getRowIndex(imwhitequeen) == row && GridPane.getColumnIndex(imwhitequeen) == column - j && column - j >= 0) {
//                for (int q = column - j + 1; q <= column - 1; q++) {
//                    for (int y = 0; y < whiteimages.size(); y++) {
//                        if (blackimages.get(y)!=imblackking&&(GridPane.getRowIndex(whiteimages.get(y)) == row && GridPane.getColumnIndex(whiteimages.get(y)) == q )||( GridPane.getRowIndex(blackimages.get(y)) == row && GridPane.getColumnIndex(blackimages.get(y)) == q )&& q <= 7) {
//                            System.out.println("whitequeen nahi rona");
//                            return false;
//                        }
//
//                    }
//                }
//                 System.out.println("whitequeen rona");
//                return true;
//            }
//
//            if (GridPane.getColumnIndex(imwhitequeen) == column && GridPane.getRowIndex(imwhitequeen) == row + j && row + j <= 7) {
//                for (int q = row + j - 1; q >= row + 1; q--) {
//                    for (int y = 0; y < whiteimages.size(); y++) {
//                        if (blackimages.get(y)!=imblackking&&(GridPane.getRowIndex(whiteimages.get(y)) == q && GridPane.getColumnIndex(whiteimages.get(y)) == column )||( GridPane.getRowIndex(blackimages.get(y)) == q && GridPane.getColumnIndex(blackimages.get(y)) == column) && q >= 0) {
//                         System.out.println("whitequeen nahi rona");
//                            return false;
//                        }
//
//                    }
//                }
//                 System.out.println("whitequeen rona");
//                return true;
//            }
//
//            if (GridPane.getColumnIndex(imwhitequeen) == column && GridPane.getRowIndex(imwhitequeen) == row - j && row - j >= 0) {
//                for (int q = row - j + 1; q <= row - 1; q++) {
//                    for (int y = 0; y < whiteimages.size(); y++) {
//                        if (blackimages.get(y)!=imblackking&&(GridPane.getRowIndex(whiteimages.get(y)) == q && GridPane.getColumnIndex(whiteimages.get(y)) == column) || (GridPane.getRowIndex(blackimages.get(y)) == q && GridPane.getColumnIndex(blackimages.get(y)) == column) && q <= 7) {
// System.out.println("whitequeen nahi rona");
//                            return false;
//                        }
//
//                    }
//                }
//                 System.out.println("whitequeen rona");
//                return true;
//            }
//        }
// System.out.println("whitequeen nahi rona");
//        return false;
//    }

    public boolean checkfirst1(int hdown, int row1, int column1, int l) {
        l = l * -1;
//             for (int i = 0; i < r.length; i++) {
//                    for (int j = 0; j < r[i].length; j++) {
//                               
        for (int k = 2; k <= 2; k++) {
            for (int i = 0; i < blackhorses.size(); i++) {
                if (GridPane.getRowIndex(blackhorses.get(i)) == hdown - 1 && GridPane.getColumnIndex(blackhorses.get(i)) == column1 - 2 && hdown - 1 >= 0 && column1 - 2 >= 0) {
                    //                   root.add(imcheck,0,4);
                    return true;
                }

                if (GridPane.getRowIndex(blackhorses.get(i)) == hdown + 1 && GridPane.getColumnIndex(blackhorses.get(i)) == column1 - 2 && hdown + 1 <= 7 && column1 - 2 >= 0) {
                    //root.add(imcheck,0,4);
                    return true;
                }
                if (GridPane.getRowIndex(blackhorses.get(i)) == hdown - 1 && GridPane.getColumnIndex(blackhorses.get(i)) == column1 + 2 && hdown - 1 >= 0 && column1 - 2 <= 7) {
                    //root.add(imcheck,0,4);
                    return true;
                }

                if (GridPane.getRowIndex(blackhorses.get(i)) == hdown + 1 && GridPane.getColumnIndex(blackhorses.get(i)) == column1 + 2 && hdown + 1 <= 7 && column1 + 2 <= 7) {
                    //root.add(imcheck,0,4);
                    return true;
                }

                if (GridPane.getRowIndex(blackhorses.get(i)) == hdown - k && GridPane.getColumnIndex(blackhorses.get(i)) == column1 - 1 && hdown - k >= 0 && column1 - 1 >= 0) {
                    //                   root.add(imcheck,0,4);
                    return true;
                }

                if (GridPane.getRowIndex(blackhorses.get(i)) == hdown + k && GridPane.getColumnIndex(blackhorses.get(i)) == column1 - 1 && hdown + k <= 7 && column1 - 1 >= 0) {
                    //root.add(imcheck,0,4);
                    return true;
                }
                if (GridPane.getRowIndex(blackhorses.get(i)) == hdown - k && GridPane.getColumnIndex(blackhorses.get(i)) == column1 + 1 && hdown - k >= 0 && column1 - 1 <= 7) {
                    //root.add(imcheck,0,4);
                    return true;
                }

                if (GridPane.getRowIndex(blackhorses.get(i)) == hdown + k && GridPane.getColumnIndex(blackhorses.get(i)) == column1 + 1 && hdown + k <= 1 && column1 + 1 <= 7) {
                    //root.add(imcheck,0,4);
                    return true;
                }
            }

        }
//                               }
//                        
//                        }
        return false;
    }

    public boolean checkblackcastle(int row, int column) {
        for (int k = 0; k < blackcastles.size(); k++) {
            for (int i = 1; i <= 7; i++) {

                if (GridPane.getRowIndex(blackcastles.get(k)) == row && GridPane.getColumnIndex(blackcastles.get(k)) == column + i && column + i <= 7) {
   System.out.println("kato 1");
                    for (int j = column + i - 1; j >= column + 1; j--) {
                    System.out.println("kato 2");
                        for (int y = 0; y < whiteimages.size(); y++) {
                            if (whiteimages.get(y)!=imwhiteking&&(GridPane.getRowIndex(whiteimages.get(y)) == row && GridPane.getColumnIndex(whiteimages.get(y)) == j) ||( GridPane.getRowIndex(blackimages.get(y)) == row && GridPane.getColumnIndex(blackimages.get(y)) == j) && j >= 0) {
                            
   System.out.println("kato 3");
                                return false;
                            }

                        }
                    }
                    return true;
                }
                if (GridPane.getRowIndex(blackcastles.get(k)) == row && GridPane.getColumnIndex(blackcastles.get(k)) == column - i && column - i >= 0) {
                     System.out.println("kato 4");
                    for (int j = column - i + 1; j <= column - 1; j++) {
                           System.out.println("kato 5");
                        for (int y = 0; y < whiteimages.size(); y++) {
                            if (whiteimages.get(y)!=imwhiteking&&(GridPane.getRowIndex(whiteimages.get(y)) == row && GridPane.getColumnIndex(whiteimages.get(y)) == j) ||( GridPane.getRowIndex(blackimages.get(y)) == row && GridPane.getColumnIndex(blackimages.get(y)) == j) && j <= 7) {
                                 System.out.println("kato 6");
                                 return false;
                            }

                        }
                    }
                    return true;
                }
//                                                    else
//                                           {
//                                           for(int j=0;j<whiteimages.size();j++)
//                                           {                                          if(GridPane.getRowIndex(whiteimages.get(j))==row&&GridPane.getColumnIndex(whiteimages.get(j))==column-i||(GridPane.getRowIndex(blackimages.get(j))==row&&GridPane.getColumnIndex(blackimages.get(j))==column-i)&&column-i>=0)
//                                           { 
//                                              //   System.out.println("ahmad");
//       return false;
//}
//                                           }}
                if (GridPane.getColumnIndex(blackcastles.get(k)) == column && GridPane.getRowIndex(blackcastles.get(k)) == row + i && row + i <= 7) {
   System.out.println("kato 7");
                    for (int j = row + i - 1; j >= row + 1; j--) {
                           System.out.println("kato 8");
                        for (int y = 0; y < whiteimages.size(); y++) {
                            if (whiteimages.get(y)!=imwhiteking&&(GridPane.getRowIndex(whiteimages.get(y)) == j && GridPane.getColumnIndex(whiteimages.get(y)) == column )|| (GridPane.getRowIndex(blackimages.get(y)) == j && GridPane.getColumnIndex(blackimages.get(y)) == column )&& j >= 0) {
                                 System.out.println("kato 9");  return false;
                            }

                        }
                    }
                    //  System.out.println("ahmad");
                    return true;
                }
//                else
//                                           {
//                                           for(int j=0;j<whiteimages.size();j++)
//                                           {                                          if(GridPane.getRowIndex(whiteimages.get(j))==row+i&&GridPane.getColumnIndex(whiteimages.get(j))==column||(GridPane.getRowIndex(blackimages.get(j))==row+i&&GridPane.getColumnIndex(blackimages.get(j))==column)&&row+i<=7)
//                                           { 
//                                            //     System.out.println("ahmad");
//       return false;
//}
//                                           }}
//        
                if (GridPane.getColumnIndex(blackcastles.get(k)) == column && GridPane.getRowIndex(blackcastles.get(k)) == row - i && row - i >= 0) {
                      System.out.println("kato 10");
                    for (int j = row - i + 1; j <= row - 1; j++) {
                        System.out.println("kato 11");
                        for (int y = 0; y < whiteimages.size(); y++) {
                            if (whiteimages.get(y)!=imwhiteking&&(GridPane.getRowIndex(whiteimages.get(y)) == j && GridPane.getColumnIndex(whiteimages.get(y)) == column )|| (GridPane.getRowIndex(blackimages.get(y)) == j && GridPane.getColumnIndex(blackimages.get(y)) == column) && j <= 7) {
   System.out.println("kato 12");
                                return false;
                            }

                        }
                    }

                    return true;
                }
//                    else
//                                           {
//                                           for(int j=0;j<whiteimages.size();j++)
//                                           {                                          if(GridPane.getRowIndex(whiteimages.get(j))==row-i&&GridPane.getColumnIndex(whiteimages.get(j))==column||(GridPane.getRowIndex(blackimages.get(j))==row-i&&GridPane.getColumnIndex(blackimages.get(j))==column)&&row-i>=0)
//                                           { 
//                                               return false;
//}
//                                           }}
//     
//        

            }

        }

        return false;
    }

    public boolean checkblackpawn(int row, int column) {
        for (int i = 0; i < blackpawns.size(); i++) {
            for (int j = 1; j <= 1; j++) {
                if (GridPane.getRowIndex(blackpawns.get(i)) == row + 1 && GridPane.getColumnIndex(blackpawns.get(i)) == column - j && column - j >= 0 && row + 1 <= 7) {
                    //System.out.println("fazool ma laga kar raki wi hai is na");
                    return true;
                }
                if (GridPane.getRowIndex(blackpawns.get(i)) == row + 1 && GridPane.getColumnIndex(blackpawns.get(i)) == column + j && column + j <= 7 && row + 1 <= 7) {
                   // System.out.println("fazool ma laga kar raki wi hai is na");
                    return true;
                }
            }
        }

        return false;
    }
//
//    public boolean checkblackbishops(int row, int column) {
//        for (int i = 0; i < blackbishops.size(); i++) {
//            for (int j = 1; j <= 7; j++) {
//                if (GridPane.getRowIndex(blackbishops.get(i)) == row - j && GridPane.getColumnIndex(blackbishops.get(i)) == column - j && column - j >= 0 && row - j >= 0) {
//                    for (int t = row - j + 1, k = column - j + 1; t <= row - 1 || k <= column - 1||t>=0; t++, k++) {
//                        for (int y = 0; y < whiteimages.size(); y++) {
//                            if ((GridPane.getRowIndex(whiteimages.get(y)) == t && GridPane.getColumnIndex(whiteimages.get(y)) == k) || (GridPane.getRowIndex(blackimages.get(y)) == t && GridPane.getColumnIndex(blackimages.get(y)) == k) && j <= 7) {
//                                if ((GridPane.getRowIndex(whiteimages.get(y)) == GridPane.getRowIndex(imwhiteking) && GridPane.getColumnIndex(whiteimages.get(y)) == GridPane.getColumnIndex(imwhiteking))) {
//                                    System.out.println("heheheeheheehe");
//                                    return true;
//                                } else {
//                                    System.out.println(":P");
//                                    return false;
//                                }
//                            }
//
//                        }
//                    }
//                    System.out.println("dude hassan");
//                    return true;
//                }
//                if (GridPane.getRowIndex(blackbishops.get(i)) == row - j && GridPane.getColumnIndex(blackbishops.get(i)) == column + j && column + j <= 7 && row - j >= 0) {
//                    for (int t = row - j + 1, k = column + j - 1; t <= row - 1 ||k <= column + 1||t>=0; t++, k--) {
//                        for (int y = 0; y < whiteimages.size(); y++) {
//                            if ((GridPane.getRowIndex(whiteimages.get(y)) == t && GridPane.getColumnIndex(whiteimages.get(y)) == k) || (GridPane.getRowIndex(blackimages.get(y)) == t && GridPane.getColumnIndex(blackimages.get(y)) == k) && j <= 7) {
//                                if ((GridPane.getRowIndex(whiteimages.get(y)) == GridPane.getRowIndex(imwhiteking) && GridPane.getColumnIndex(whiteimages.get(y)) == GridPane.getColumnIndex(imwhiteking))) {
//                                    System.out.println("heheheeheheehe");
//                                    return true;
//                                } else {
//                                    System.out.println(":P");
//                                    return false;
//                                }
//                            }
//
//                        }
//                    }
//                    System.out.println("rude hassan");
//                    return true;
//                }
//
//                if (GridPane.getRowIndex(blackbishops.get(i)) == row + j && GridPane.getColumnIndex(blackbishops.get(i)) == column - j && column - j >= 0 && row + j <= 7) {
//
//                    for (int t = row + j - 1, k = column - j + 1; t <= row + 1 || k <= column - 1||t>=0; t--, k++) {
//                        // System.out.println(t);
//                        for (int y = 0; y < whiteimages.size(); y++) {
//                            if ((GridPane.getRowIndex(whiteimages.get(y)) == t && GridPane.getColumnIndex(whiteimages.get(y)) == k) || (GridPane.getRowIndex(blackimages.get(y)) == t && GridPane.getColumnIndex(blackimages.get(y)) == k) && j <= 7) {
//                                if ((GridPane.getRowIndex(whiteimages.get(y)) == GridPane.getRowIndex(imwhiteking) && GridPane.getColumnIndex(whiteimages.get(y)) == GridPane.getColumnIndex(imwhiteking))) {
//                                    System.out.println("heheheeheheehe");
//                                    return true;
//                                } else {
//                                    System.out.println(":P");
//                                    return false;
//                                }
//                            }
//
//                        }
//                    }
//                    System.out.println("cude hassan");
//                    return true;
//                }
//                if (GridPane.getRowIndex(blackbishops.get(i)) == row + j && GridPane.getColumnIndex(blackbishops.get(i)) == column + j && column + j <= 7 && row + j <= 7) {
//                    for (int t = row + j - 1, k = column + j - 1; t <= row + 1 || k <= column + 1||t>=0; t--, k--) {
//                        for (int y = 0; y < whiteimages.size(); y++) {
//                            if ((GridPane.getRowIndex(whiteimages.get(y)) == t && GridPane.getColumnIndex(whiteimages.get(y)) == k) || (GridPane.getRowIndex(blackimages.get(y)) == t && GridPane.getColumnIndex(blackimages.get(y)) == k) && j <= 7) {
//                                if ((GridPane.getRowIndex(whiteimages.get(y)) == GridPane.getRowIndex(imwhiteking) && GridPane.getColumnIndex(whiteimages.get(y)) == GridPane.getColumnIndex(imwhiteking))) {
//                                    System.out.println("heheheeheheehe");
//                                    return true;
//                                } else {
//                                    System.out.println(":P");
//                                    return false;
//                                }
//                            }
//
//                        }
//                    }
//                    System.out.println("fude hassan");
//                    return true;
//                }
//            }
//        }
//
//        return false;
////    }
//    public boolean checkblackbishops(int row, int column) {
//        for (int i = 0; i < blackbishops.size(); i++) {
//            for (int j = 1; j <= 7; j++) {
//                if (GridPane.getRowIndex(blackbishops.get(i)) == row - j && GridPane.getColumnIndex(blackbishops.get(i)) == column - j && column - j >= 0 && row - j >= 0) {
//                    for (int t = row - j + 1, k = column - j + 1; t <= row - 1 || k <= column - 1||t>=0; t++, k++) {
//                        for (int y = 0; y < whiteimages.size(); y++) {
//                          if ((GridPane.getRowIndex(whiteimages.get(y)) == t && GridPane.getColumnIndex(whiteimages.get(y)) == k) || (GridPane.getRowIndex(blackimages.get(y)) == t && GridPane.getColumnIndex(blackimages.get(y)) == k) && j <= 7) {
//                            if ((GridPane.getRowIndex(whiteimages.get(y)) == GridPane.getRowIndex(imwhiteking) && GridPane.getColumnIndex(whiteimages.get(y)) == GridPane.getColumnIndex(imwhiteking))) {
//                     //           System.out.println("heheheeheheehe");
//                                return true;
//                            } else {
//                   //             System.out.println(":P");
//                                return false;
//                            }
//                            
//                        }
//                             if(t==row&&k==column)
//                          {return true;}
//                        }
//                    }
//
//                    return true;
//                }
//                if (GridPane.getRowIndex(blackbishops.get(i)) == row - j && GridPane.getColumnIndex(blackbishops.get(i)) == column + j && column + j <= 7 && row - j >= 0) {
//                    for (int t = row - j + 1, k = column + j - 1; t <= row - 1 || k <= column + 1; t++, k--) {
//                        for (int y = 0; y < whiteimages.size(); y++) {
//                          if ((GridPane.getRowIndex(whiteimages.get(y)) == t && GridPane.getColumnIndex(whiteimages.get(y)) == k) || (GridPane.getRowIndex(blackimages.get(y)) == t && GridPane.getColumnIndex(blackimages.get(y)) == k) && j <= 7) {
//                            if ((GridPane.getRowIndex(whiteimages.get(y)) == GridPane.getRowIndex(imwhiteking) && GridPane.getColumnIndex(whiteimages.get(y)) == GridPane.getColumnIndex(imwhiteking))) {
//                 //               System.out.println("heheheeheheehe");
//                                return true;
//                            } else {
//               //                 System.out.println(":P");
//                                return false;
//                            }
//                        }
//                             if(t==row&&k==column)
//                          {return true;}
//                        }
//                    }
//                    return true;
//                }
//
//                if (GridPane.getRowIndex(blackbishops.get(i)) == row + j && GridPane.getColumnIndex(blackbishops.get(i)) == column - j && column - j >= 0 && row + j <= 7) {
//                    for (int t = row + j - 1, k = column - j + 1; t <= row + 1 || k <= column - 1; t--, k++) {
//                        for (int y = 0; y < whiteimages.size(); y++) {
//                          if ((GridPane.getRowIndex(whiteimages.get(y)) == t && GridPane.getColumnIndex(whiteimages.get(y)) == k) || (GridPane.getRowIndex(blackimages.get(y)) == t && GridPane.getColumnIndex(blackimages.get(y)) == k) && j <= 7) {
//                            if ((GridPane.getRowIndex(whiteimages.get(y)) == GridPane.getRowIndex(imwhiteking) && GridPane.getColumnIndex(whiteimages.get(y)) == GridPane.getColumnIndex(imwhiteking))) {
//             //                   System.out.println("heheheeheheehe");
//                                return true;
//                            } else {
//           //                     System.out.println(":P");
//                                return false;
//                            }
//                        }
//                             if(t==row&&k==column)
//                          {return true;}
//                        }
//                    }
//                    return true;
//                }
//                if (GridPane.getRowIndex(blackbishops.get(i)) == row + j && GridPane.getColumnIndex(blackbishops.get(i)) == column + j && column + j <= 7 && row + j <= 7) {
//                    for (int t = row + j - 1, k = column + j - 1; t <= row + 1 || k <= column + 1; t--, k--) {
//                        for (int y = 0; y < whiteimages.size(); y++) {
//                          if ((GridPane.getRowIndex(whiteimages.get(y)) == t && GridPane.getColumnIndex(whiteimages.get(y)) == k) || (GridPane.getRowIndex(blackimages.get(y)) == t && GridPane.getColumnIndex(blackimages.get(y)) == k) && j <= 7) {
//                            if ((GridPane.getRowIndex(whiteimages.get(y)) == GridPane.getRowIndex(imwhiteking) && GridPane.getColumnIndex(whiteimages.get(y)) == GridPane.getColumnIndex(imwhiteking))) {
//         //                       System.out.println("heheheeheheehe");
//                                return true;
//                            } else {
//       //                         System.out.println(":P");
//                                return false;
//                            }
//                        }
//                             if(t==row&&k==column)
//                          {return true;}
//                        }
//                    }
//                    return true;
//                }
//            }
//        }
//
//        return false;
//    }
//  public boolean checkblackqueen(int row, int column) {
//        for (int j = 1; j <= 7; j++) {
//            if (GridPane.getRowIndex(imblackqueen) == row - j && GridPane.getColumnIndex(imblackqueen) == column - j && column - j >= 0 && row - j >= 0) {
//                int count=0;
//                for (int t = row - j + 1, k = column - j + 1; t <= row - 1 || k <= column - 1||t>=0; t++, k++,count++) {
//                    if(count==20)
//                    {break;}
//                    for (int y = 0; y < whiteimages.size(); y++) {
//   if ((GridPane.getRowIndex(whiteimages.get(y)) == t && GridPane.getColumnIndex(whiteimages.get(y)) == k) || (GridPane.getRowIndex(blackimages.get(y)) == t && GridPane.getColumnIndex(blackimages.get(y)) == k) && j <= 7) {
//                            if ((GridPane.getRowIndex(whiteimages.get(y)) == GridPane.getRowIndex(imwhiteking) && GridPane.getColumnIndex(whiteimages.get(y)) == GridPane.getColumnIndex(imwhiteking))) {
//     //                         System.out.println("2");
//                      return true;
//                            } else {
//   //                            System.out.println("3");
//                                return false;
//                            }
//                        }
//      if(t==row&&k==column)
//                          {return true;}
//
//                    }
//                }
// //System.out.println("4");
//                return true;
//            }
//            if (GridPane.getRowIndex(imblackqueen) == row - j && GridPane.getColumnIndex(imblackqueen) == column + j && column + j <= 7 && row - j >= 0) {
//                //System.out.println("5");
//               int count=0;
//                for (int t = row - j + 1, k = column + j - 1; t <= row - 1 || k <= column + 1||t>=0; t++, k--,count++) {
//                 if(count==20)
//                    {break;}
//                    for (int y = 0; y < whiteimages.size(); y++) {
//                        if ((GridPane.getRowIndex(whiteimages.get(y)) == t && GridPane.getColumnIndex(whiteimages.get(y)) == k) || (GridPane.getRowIndex(blackimages.get(y)) == t && GridPane.getColumnIndex(blackimages.get(y)) == k) && j <= 7) {
//                            if ((GridPane.getRowIndex(whiteimages.get(y)) == GridPane.getRowIndex(imwhiteking) && GridPane.getColumnIndex(whiteimages.get(y)) == GridPane.getColumnIndex(imwhiteking))) {
//                                 System.out.println("7");
//                                 return true;
//                            } else {
//                  //               System.out.println("8");
//                                 return false;
//                            }
//                        }
//   if(t==row&&k==column)
//                          {return true;}
//                    }
//                }
//                // System.out.println("9");
//                return true;
//            }
//
//            if (GridPane.getRowIndex(imblackqueen) == row + j && GridPane.getColumnIndex(imblackqueen) == column - j && column - j >= 0 && row + j <= 7) {
//                System.out.println("10");
//              //int count=0;
//                for (int t = row + j - 1, k = column - j + 1; t <= row + 1 || k <= column - 1||t>=0;count++, t--, k++) {
//                    System.out.println("11");
//                   if(count==20)
//                    {break;}
//                    for (int y = 0; y < whiteimages.size(); y++) {
//                        if ((GridPane.getRowIndex(whiteimages.get(y)) == t && GridPane.getColumnIndex(whiteimages.get(y)) == k) || (GridPane.getRowIndex(blackimages.get(y)) == t && GridPane.getColumnIndex(blackimages.get(y)) == k) && j <= 7) {
//                            if ((GridPane.getRowIndex(whiteimages.get(y)) == GridPane.getRowIndex(imwhiteking) && GridPane.getColumnIndex(whiteimages.get(y)) == GridPane.getColumnIndex(imwhiteking))) {
//                                System.out.println("12");
//                                return true;
//                            } else {
//            //                     System.out.println("13");return false;
//                            }
//                        }
//                           if(t==row&&k==column)
//                          {return true;}
//                    }
//                }
//          //      System.out.println("14");
//                return true;
//            }
//            if (GridPane.getRowIndex(imblackqueen) == row + j && GridPane.getColumnIndex(imblackqueen) == column + j && column + j <= 7 && row + j <= 7) {
//        //        System.out.println("15");
//                int count=0;
//                for (int t = row + j - 1, k = column + j - 1; t <= row + 1 || k <= column + 1||t>0; t--, k--,count++) {
//                    System.out.println("16");
//                    if(count==20)
//                    {break;}
//                    for (int y = 0; y < whiteimages.size(); y++) {
//                        if ((GridPane.getRowIndex(whiteimages.get(y)) == t && GridPane.getColumnIndex(whiteimages.get(y)) == k) || (GridPane.getRowIndex(blackimages.get(y)) == t && GridPane.getColumnIndex(blackimages.get(y)) == k) && j <= 7) {
//                            if ((GridPane.getRowIndex(whiteimages.get(y)) == GridPane.getRowIndex(imwhiteking) && GridPane.getColumnIndex(whiteimages.get(y)) == GridPane.getColumnIndex(imwhiteking))) {
//                                 System.out.println("17");
//      //                          return true;
//                            } else {
//    //                           System.out.println("18");
//                                return false;
//                            }
//                        }
//                           if(t==row&&k==column)
//                          {return true;}
//                    }
//                }
//  //               System.out.println("19");
//                return true;
//            }
//            if (GridPane.getRowIndex(imblackqueen) == row && GridPane.getColumnIndex(imblackqueen) == column + j && column + j <= 7) {
//                for (int q = column + j - 1; q >= column + 1; q--) {
//                    for (int y = 0; y < whiteimages.size(); y++) {
//                        if (whiteimages.get(y)!=imwhiteking&&(GridPane.getRowIndex(whiteimages.get(y)) == row && GridPane.getColumnIndex(whiteimages.get(y)) == q )|| (GridPane.getRowIndex(blackimages.get(y)) == row && GridPane.getColumnIndex(blackimages.get(y)) == q) && q >= 0) {
//// System.out.println("blackqueen nahi rona");
//                            return false;
//                        }
//
//                    }
//                }
//          //       System.out.println("blackqueen rona");
//                return true;
//            }
//
//            if (GridPane.getRowIndex(imblackqueen) == row && GridPane.getColumnIndex(imblackqueen) == column - j && column - j >= 0) {
//                for (int q = column - j + 1; q <= column - 1; q++) {
//                    for (int y = 0; y < whiteimages.size(); y++) {
//                        if (whiteimages.get(y)!=imwhiteking&&(GridPane.getRowIndex(whiteimages.get(y)) == row && GridPane.getColumnIndex(whiteimages.get(y)) == q )|| (GridPane.getRowIndex(blackimages.get(y)) == row && GridPane.getColumnIndex(blackimages.get(y)) == q )&& q <= 7) {
//        //                    System.out.println("blackqueen nahi rona");
//                            return false;
//                        }
//
//                    }
//                }
//      //           System.out.println("blackqueen rona");
//                return true;
//            }
//
//            if (GridPane.getColumnIndex(imblackqueen) == column && GridPane.getRowIndex(imblackqueen) == row + j && row + j <= 7) {
//                for (int q = row + j - 1; q >= row + 1; q--) {
//                    for (int y = 0; y < whiteimages.size(); y++) {
//                        if (whiteimages.get(y)!=imwhiteking&&(GridPane.getRowIndex(whiteimages.get(y)) == q && GridPane.getColumnIndex(whiteimages.get(y)) == column) || (GridPane.getRowIndex(blackimages.get(y)) == q && GridPane.getColumnIndex(blackimages.get(y)) == column) && q >= 0) {
//    //                     System.out.println("blackqueen nahi rona");
//                            return false;
//                        }
//
//                    }
//                }
//  //               System.out.println("blackqueen rona");
//                return true;
//            }
//
//            if (GridPane.getColumnIndex(imblackqueen) == column && GridPane.getRowIndex(imblackqueen) == row - j && row - j >= 0) {
//                for (int q = row - j + 1; q <= row - 1; q++) {
//                    for (int y = 0; y < whiteimages.size(); y++) {
//                        if (whiteimages.get(y)!=imwhiteking&&(GridPane.getRowIndex(whiteimages.get(y)) == q && GridPane.getColumnIndex(whiteimages.get(y)) == column) || (GridPane.getRowIndex(blackimages.get(y)) == q && GridPane.getColumnIndex(blackimages.get(y)) == column) && q <= 7) {
//// System.out.println("blackqueen nahi rona");
//                            return false;
//                        }
//
//                    }
//                }
// //                System.out.println("blackqueen rona");
//                return true;
//            }
//        }
// 
//        return false;
//    }
    
    public boolean checkblackbishops(int row, int column) {
        for (int i = 0; i < blackbishops.size(); i++) {
            for (int j = 1; j <= 7; j++) {
                if (GridPane.getRowIndex(blackbishops.get(i)) == row - j && GridPane.getColumnIndex(blackbishops.get(i)) == column - j && column - j >= 0 && row - j >= 0) {
                    for (int t = row - j + 1, k = column - j + 1; t <= row - 1 || k <= column - 1; t++, k++) {
                        for (int y = 0; y < whiteimages.size(); y++) {
                          if ((GridPane.getRowIndex(whiteimages.get(y)) == t && GridPane.getColumnIndex(whiteimages.get(y)) == k) || (GridPane.getRowIndex(blackimages.get(y)) == t && GridPane.getColumnIndex(blackimages.get(y)) == k) && j <= 7) {
                            if ((GridPane.getRowIndex(whiteimages.get(y)) == GridPane.getRowIndex(imwhiteking) && GridPane.getColumnIndex(whiteimages.get(y)) == GridPane.getColumnIndex(imwhiteking))||(whiteimages.get(y)==blackbishops.get(i))) {
                                System.out.println("heheheeheheehe1");
                                return true;
                            } else {
                                System.out.println(":P1");
                                return false;
                            }
                        }
                           if(t==row&&k==column)
                          {return true;}
                        
                        }
                    }

                    return true;
                }
                if (GridPane.getRowIndex(blackbishops.get(i)) == row - j && GridPane.getColumnIndex(blackbishops.get(i)) == column + j && column + j <= 7 && row - j >= 0) {
                    for (int t = row - j + 1, k = column + j - 1; t <= row - 1 || k <= column + 1||t>=0; t++, k--) {
                        for (int y = 0; y < whiteimages.size(); y++) {
                          if ((GridPane.getRowIndex(whiteimages.get(y)) == t && GridPane.getColumnIndex(whiteimages.get(y)) == k) || (GridPane.getRowIndex(blackimages.get(y)) == t && GridPane.getColumnIndex(blackimages.get(y)) == k) && j <= 7) {
                            if ((GridPane.getRowIndex(blackimages.get(y)) == GridPane.getRowIndex(imblackking) && GridPane.getColumnIndex(blackimages.get(y)) == GridPane.getColumnIndex(imblackking))||(blackimages.get(y)==blackbishops.get(i))) {
                                System.out.println("heheheeheheehe2");
                                return true;
                            } else {
                                System.out.println(":P2");
                                return false;
                            }
                        }
                          if(t==row&&k==column)
                          {return true;}
                        }
                    }
                    return true;
                }

                if (GridPane.getRowIndex(blackbishops.get(i)) == row + j && GridPane.getColumnIndex(blackbishops.get(i)) == column - j && column - j >= 0 && row + j <= 7) {
                    for (int t = row + j - 1, k = column - j + 1; t <= row + 1 || k <= column - 1||t>=0; t--, k++) {
                        for (int y = 0; y < whiteimages.size(); y++) {
                          if ((GridPane.getRowIndex(whiteimages.get(y)) == t && GridPane.getColumnIndex(whiteimages.get(y)) == k) || (GridPane.getRowIndex(blackimages.get(y)) == t && GridPane.getColumnIndex(blackimages.get(y)) == k) && j <= 7) {
                            if ((GridPane.getRowIndex(whiteimages.get(y)) == GridPane.getRowIndex(imwhiteking) && GridPane.getColumnIndex(whiteimages.get(y)) == GridPane.getColumnIndex(imwhiteking))||(blackimages.get(y)==blackbishops.get(i))) {
                                System.out.println("heheheeheheehe3");
                                return true;
                            } else {
                                System.out.println(":P3");
                                return false;
                            }
                        }
                             if(t==row&&k==column)
                          {return true;}
                        }
                    }
                    return true;
                }
                if (GridPane.getRowIndex(blackbishops.get(i)) == row + j && GridPane.getColumnIndex(blackbishops.get(i)) == column + j && column + j <= 7 && row + j <= 7) {
                    for (int t = row + j - 1, k = column + j - 1; t <= row + 1 || k <= column + 1||t>=0; t--, k--) {
                        for (int y = 0; y < whiteimages.size(); y++) {
                          if ((GridPane.getRowIndex(whiteimages.get(y)) == t && GridPane.getColumnIndex(whiteimages.get(y)) == k) || (GridPane.getRowIndex(blackimages.get(y)) == t && GridPane.getColumnIndex(blackimages.get(y)) == k) && j <= 7) {
                            if ((GridPane.getRowIndex(whiteimages.get(y)) == GridPane.getRowIndex(imwhiteking) && GridPane.getColumnIndex(whiteimages.get(y)) == GridPane.getColumnIndex(imwhiteking))||(blackimages.get(y)==blackbishops.get(i))) {
                                System.out.println("heheheeheheehe4");
                                return true;
                            } else {
                                System.out.println(":P4");
                                return false;
                            }
                        }
                             if(t==row&&k==column)
                          {return true;}
                        }
                    }
                    return true;
                }
            }
        }

        return false;
    }
public boolean checkblackqueen(int row, int column) {
        for (int j = 1; j <= 7; j++) {
            if (GridPane.getRowIndex(imblackqueen) == row - j && GridPane.getColumnIndex(imblackqueen) == column - j && column - j >= 0 && row - j >= 0) {
                int count=0;
                for (int t = row - j + 1, k = column - j + 1; t <= row - 1 || k <= column - 1||t>=0; t++, k++,count++) {
                    if(count==20)
                    {break;}
                    for (int y = 0; y < whiteimages.size(); y++) {
   if ((GridPane.getRowIndex(whiteimages.get(y)) == t && GridPane.getColumnIndex(whiteimages.get(y)) == k) || (GridPane.getRowIndex(blackimages.get(y)) == t && GridPane.getColumnIndex(blackimages.get(y)) == k) && j <= 7) {
                            if ((GridPane.getRowIndex(whiteimages.get(y)) == GridPane.getRowIndex(imwhiteking) && GridPane.getColumnIndex(whiteimages.get(y)) == GridPane.getColumnIndex(imwhiteking))) {
  //                            System.out.println("2");
                      return true;
                            } else {
    //                           System.out.println("3");
                                return false;
                            }
                        }
      if(t==row&&k==column)
                          {return true;}

                    }
                }
 //System.out.println("4");
                return true;
            }
            if (GridPane.getRowIndex(imblackqueen) == row - j && GridPane.getColumnIndex(imblackqueen) == column + j && column + j <= 7 && row - j >= 0) {
      //          System.out.println("5");
               int count=0;
                for (int t = row - j + 1, k = column + j - 1; t <= row - 1 || k <= column + 1||t>=0; t++, k--,count++) {
                 if(count==20)
                    {break;}
                    for (int y = 0; y < whiteimages.size(); y++) {
                        if ((GridPane.getRowIndex(whiteimages.get(y)) == t && GridPane.getColumnIndex(whiteimages.get(y)) == k) || (GridPane.getRowIndex(blackimages.get(y)) == t && GridPane.getColumnIndex(blackimages.get(y)) == k) && j <= 7) {
                            if ((GridPane.getRowIndex(whiteimages.get(y)) == GridPane.getRowIndex(imwhiteking) && GridPane.getColumnIndex(whiteimages.get(y)) == GridPane.getColumnIndex(imwhiteking))) {
                                 System.out.println("7");
                                 return true;
                            } else {
                                 System.out.println("8");
                                 return false;
                            }
                        }
                           if(t==row&&k==column)
                          {return true;}

                    }
                }
                 System.out.println("9");
                return true;
            }

            if (GridPane.getRowIndex(imblackqueen) == row + j && GridPane.getColumnIndex(imblackqueen) == column - j && column - j >= 0 && row + j <= 7) {
                System.out.println("10");
              int count=0;
                for (int t = row + j - 1, k = column - j + 1; t <= row + 1 || k <= column - 1||t>=0;count++, t--, k++) {
                    System.out.println("11");
                   if(count==20)
                    {break;}
                    for (int y = 0; y < whiteimages.size(); y++) {
                        if ((GridPane.getRowIndex(whiteimages.get(y)) == t && GridPane.getColumnIndex(whiteimages.get(y)) == k) || (GridPane.getRowIndex(blackimages.get(y)) == t && GridPane.getColumnIndex(blackimages.get(y)) == k) && j <= 7) {
                            if ((GridPane.getRowIndex(whiteimages.get(y)) == GridPane.getRowIndex(imwhiteking) && GridPane.getColumnIndex(whiteimages.get(y)) == GridPane.getColumnIndex(imwhiteking))) {
                                System.out.println("12");
                                return true;
                            } else {
                                 System.out.println("13");return false;
                            }
                        }
                           if(t==row&&k==column)
                          {return true;}
                    }
                }
                System.out.println("14");
                return true;
            }
            if (GridPane.getRowIndex(imblackqueen) == row + j && GridPane.getColumnIndex(imblackqueen) == column + j && column + j <= 7 && row + j <= 7) {
                System.out.println("15");
                int count=0;
                for (int t = row + j - 1, k = column + j - 1; t <= row + 1 || k <= column + 1||t>0; t--, k--,count++) {
                    System.out.println("16");
                    if(count==20)
                    {break;}
                    for (int y = 0; y < whiteimages.size(); y++) {
                        if ((GridPane.getRowIndex(whiteimages.get(y)) == t && GridPane.getColumnIndex(whiteimages.get(y)) == k) || (GridPane.getRowIndex(blackimages.get(y)) == t && GridPane.getColumnIndex(blackimages.get(y)) == k) && j <= 7) {
                            if ((GridPane.getRowIndex(whiteimages.get(y)) == GridPane.getRowIndex(imwhiteking) && GridPane.getColumnIndex(whiteimages.get(y)) == GridPane.getColumnIndex(imwhiteking))) {
                                 System.out.println("17");
                                return true;
                            } else {
                               System.out.println("18");
                                return false;
                            }
                        }
                           if(t==row&&k==column)
                          {return true;}
                    }
                }
                 System.out.println("19");
                return true;
            }
            if (GridPane.getRowIndex(imblackqueen) == row && GridPane.getColumnIndex(imblackqueen) == column + j && column + j <= 7) {
                for (int q = column + j - 1; q >= column + 1; q--) {
                    for (int y = 0; y < whiteimages.size(); y++) {
                        if (whiteimages.get(y)!=imwhiteking&&(GridPane.getRowIndex(whiteimages.get(y)) == row && GridPane.getColumnIndex(whiteimages.get(y)) == q )|| (GridPane.getRowIndex(blackimages.get(y)) == row && GridPane.getColumnIndex(blackimages.get(y)) == q) && q >= 0) {
// System.out.println("blackqueen nahi rona");
                            return false;
                        }

                    }
                }
  //               System.out.println("blackqueen rona");
                return true;
            }

            if (GridPane.getRowIndex(imblackqueen) == row && GridPane.getColumnIndex(imblackqueen) == column - j && column - j >= 0) {
                for (int q = column - j + 1; q <= column - 1; q++) {
                    for (int y = 0; y < whiteimages.size(); y++) {
                        if (whiteimages.get(y)!=imwhiteking&&(GridPane.getRowIndex(whiteimages.get(y)) == row && GridPane.getColumnIndex(whiteimages.get(y)) == q )|| (GridPane.getRowIndex(blackimages.get(y)) == row && GridPane.getColumnIndex(blackimages.get(y)) == q )&& q <= 7) {
    //                        System.out.println("blackqueen nahi rona");
                            return false;
                        }

                    }
                }
      //           System.out.println("blackqueen rona");
                return true;
            }

            if (GridPane.getColumnIndex(imblackqueen) == column && GridPane.getRowIndex(imblackqueen) == row + j && row + j <= 7) {
                for (int q = row + j - 1; q >= row + 1; q--) {
                    for (int y = 0; y < whiteimages.size(); y++) {
                        if (whiteimages.get(y)!=imwhiteking&&(GridPane.getRowIndex(whiteimages.get(y)) == q && GridPane.getColumnIndex(whiteimages.get(y)) == column) || (GridPane.getRowIndex(blackimages.get(y)) == q && GridPane.getColumnIndex(blackimages.get(y)) == column) && q >= 0) {
        //                 System.out.println("blackqueen nahi rona");
                            return false;
                        }

                    }
                }
          //       System.out.println("blackqueen rona");
                return true;
            }

            if (GridPane.getColumnIndex(imblackqueen) == column && GridPane.getRowIndex(imblackqueen) == row - j && row - j >= 0) {
                for (int q = row - j + 1; q <= row - 1; q++) {
                    for (int y = 0; y < whiteimages.size(); y++) {
                        if (whiteimages.get(y)!=imwhiteking&&(GridPane.getRowIndex(whiteimages.get(y)) == q && GridPane.getColumnIndex(whiteimages.get(y)) == column) || (GridPane.getRowIndex(blackimages.get(y)) == q && GridPane.getColumnIndex(blackimages.get(y)) == column) && q <= 7) {
 //System.out.println("blackqueen nahi rona");
                            return false;
                        }

                    }
                }
   //              System.out.println("blackqueen rona");
                return true;
            }
        }
 //System.out.println("blackqueen nahi rona");
        return false;
    }

//public boolean checkblackqueen(int row, int column) {
//        for (int j = 1; j <= 7; j++) {
//            if (GridPane.getRowIndex(imblackqueen) == row - j && GridPane.getColumnIndex(imblackqueen) == column - j && column - j >= 0 && row - j >= 0) {
//                for (int t = row - j + 1, k = column - j + 1; t <= row - 1 || k <= column - 1; t++, k++) {
//                    for (int y = 0; y < whiteimages.size(); y++) {
//   if ((GridPane.getRowIndex(whiteimages.get(y)) == t && GridPane.getColumnIndex(whiteimages.get(y)) == k) || (GridPane.getRowIndex(blackimages.get(y)) == t && GridPane.getColumnIndex(blackimages.get(y)) == k) && j <= 7) {
//                            if ((GridPane.getRowIndex(whiteimages.get(y)) == GridPane.getRowIndex(imwhiteking) && GridPane.getColumnIndex(whiteimages.get(y)) == GridPane.getColumnIndex(imwhiteking))) {
//                              System.out.println("blackqueen rona");
//                      return true;
//                            } else {
//                               System.out.println("blackqueen nahi rona");
//                                return false;
//                            }
//                        }
//
//                    }
//                }
// System.out.println("blackqueen rona");
//                return true;
//            }
//            if (GridPane.getRowIndex(imblackqueen) == row - j && GridPane.getColumnIndex(imblackqueen) == column + j && column + j <= 7 && row - j >= 0) {
//                for (int t = row - j + 1, k = column + j - 1; t <= row - 1 || k <= column + 1; t++, k--) {
//                    for (int y = 0; y < whiteimages.size(); y++) {
//                        if ((GridPane.getRowIndex(whiteimages.get(y)) == t && GridPane.getColumnIndex(whiteimages.get(y)) == k) || (GridPane.getRowIndex(blackimages.get(y)) == t && GridPane.getColumnIndex(blackimages.get(y)) == k) && j <= 7) {
//                            if ((GridPane.getRowIndex(whiteimages.get(y)) == GridPane.getRowIndex(imwhiteking) && GridPane.getColumnIndex(whiteimages.get(y)) == GridPane.getColumnIndex(imwhiteking))) {
//                                 System.out.println("blackqueen rona");
//                                 return true;
//                            } else {
//                                 System.out.println("blackqueen nahi rona");
//                                 return false;
//                            }
//                        }
//
//                    }
//                }
//                 System.out.println("blackqueen rona");
//                return true;
//            }
//
//            if (GridPane.getRowIndex(imblackqueen) == row + j && GridPane.getColumnIndex(imblackqueen) == column - j && column - j >= 0 && row + j <= 7) {
//                for (int t = row + j - 1, k = column - j + 1; t <= row + 1 || k <= column - 1; t--, k++) {
//                    for (int y = 0; y < whiteimages.size(); y++) {
//                        if ((GridPane.getRowIndex(whiteimages.get(y)) == t && GridPane.getColumnIndex(whiteimages.get(y)) == k) || (GridPane.getRowIndex(blackimages.get(y)) == t && GridPane.getColumnIndex(blackimages.get(y)) == k) && j <= 7) {
//                            if ((GridPane.getRowIndex(whiteimages.get(y)) == GridPane.getRowIndex(imwhiteking) && GridPane.getColumnIndex(whiteimages.get(y)) == GridPane.getColumnIndex(imwhiteking))) {
//                                System.out.println("blackqueen rona");
//                                return true;
//                            } else {
//                                 System.out.println("blackqueen nahi rona");return false;
//                            }
//                        }
//                    }
//                }
//                return true;
//            }
//            if (GridPane.getRowIndex(imblackqueen) == row + j && GridPane.getColumnIndex(imblackqueen) == column + j && column + j <= 7 && row + j <= 7) {
//                for (int t = row + j - 1, k = column + j - 1; t <= row + 1 || k <= column + 1; t--, k--) {
//                    for (int y = 0; y < whiteimages.size(); y++) {
//                        if ((GridPane.getRowIndex(whiteimages.get(y)) == t && GridPane.getColumnIndex(whiteimages.get(y)) == k) || (GridPane.getRowIndex(blackimages.get(y)) == t && GridPane.getColumnIndex(blackimages.get(y)) == k) && j <= 7) {
//                            if ((GridPane.getRowIndex(whiteimages.get(y)) == GridPane.getRowIndex(imwhiteking) && GridPane.getColumnIndex(whiteimages.get(y)) == GridPane.getColumnIndex(imwhiteking))) {
//                                 System.out.println("blackqueen rona");
//                                return true;
//                            } else {
//                               System.out.println("blackqueen nahi rona");
//                                return false;
//                            }
//                        }
//                    }
//                }
//                 System.out.println("blackqueen rona");
//                return true;
//            }
//            if (GridPane.getRowIndex(imblackqueen) == row && GridPane.getColumnIndex(imblackqueen) == column + j && column + j <= 7) {
//                for (int q = column + j - 1; q >= column + 1; q--) {
//                    for (int y = 0; y < whiteimages.size(); y++) {
//                        if (GridPane.getRowIndex(whiteimages.get(y)) == row && GridPane.getColumnIndex(whiteimages.get(y)) == q || GridPane.getRowIndex(blackimages.get(y)) == row && GridPane.getColumnIndex(blackimages.get(y)) == q && q >= 0) {
// System.out.println("blackqueen nahi rona");
//                            return false;
//                        }
//
//                    }
//                }
//                 System.out.println("blackqueen rona");
//                return true;
//            }
//
//            if (GridPane.getRowIndex(imblackqueen) == row && GridPane.getColumnIndex(imblackqueen) == column - j && column - j >= 0) {
//                for (int q = column - j + 1; q <= column - 1; q++) {
//                    for (int y = 0; y < whiteimages.size(); y++) {
//                        if (GridPane.getRowIndex(whiteimages.get(y)) == row && GridPane.getColumnIndex(whiteimages.get(y)) == q || GridPane.getRowIndex(blackimages.get(y)) == row && GridPane.getColumnIndex(blackimages.get(y)) == q && q <= 7) {
//                            System.out.println("blackqueen nahi rona");
//                            return false;
//                        }
//
//                    }
//                }
//                 System.out.println("blackqueen rona");
//                return true;
//            }
//
//            if (GridPane.getColumnIndex(imblackqueen) == column && GridPane.getRowIndex(imblackqueen) == row + j && row + j <= 7) {
//                for (int q = row + j - 1; q >= row + 1; q--) {
//                    for (int y = 0; y < whiteimages.size(); y++) {
//                        if (GridPane.getRowIndex(whiteimages.get(y)) == q && GridPane.getColumnIndex(whiteimages.get(y)) == column || GridPane.getRowIndex(blackimages.get(y)) == q && GridPane.getColumnIndex(blackimages.get(y)) == column && q >= 0) {
//                         System.out.println("blackqueen nahi rona");
//                            return false;
//                        }
//
//                    }
//                }
//                 System.out.println("blackqueen rona");
//                return true;
//            }
//
//            if (GridPane.getColumnIndex(imblackqueen) == column && GridPane.getRowIndex(imblackqueen) == row - j && row - j >= 0) {
//                for (int q = row - j + 1; q <= row - 1; q++) {
//                    for (int y = 0; y < whiteimages.size(); y++) {
//                        if (GridPane.getRowIndex(whiteimages.get(y)) == q && GridPane.getColumnIndex(whiteimages.get(y)) == column || GridPane.getRowIndex(blackimages.get(y)) == q && GridPane.getColumnIndex(blackimages.get(y)) == column && q <= 7) {
// System.out.println("blackqueen nahi rona");
//                            return false;
//                        }
//
//                    }
//                }
//                 System.out.println("blackqueen rona");
//                return true;
//            }
//        }
// System.out.println("blackqueen nahi rona");
//        return false;
//    }



    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
