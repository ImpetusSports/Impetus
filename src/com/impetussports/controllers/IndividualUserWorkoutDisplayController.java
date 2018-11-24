/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impetussports.controllers;

import com.impetussports.utils.RandomColor;
import com.impetussports.utils.StatusTimer;
import eu.hansolo.tilesfx.Tile;
import eu.hansolo.tilesfx.Tile.SkinType;
import eu.hansolo.tilesfx.TileBuilder;
import eu.hansolo.tilesfx.chart.ChartData;
import eu.hansolo.tilesfx.skins.BarChartItem;
import eu.hansolo.tilesfx.skins.LeaderBoardItem;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.AnimationTimer;
import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.paint.Color;
import javafx.scene.paint.Stop;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Michael Orner
 */
public class IndividualUserWorkoutDisplayController implements Initializable {

    private static final double TILE_SIZE = 300;
    private static final Random RND = new Random();
    private long lastTimerCall;
    long counter = 0;
    private long lastLeaderBoard;
    private StatusTimer timer;
    private DoubleProperty value;

    @FXML
    private Tile gaugeSparkLineTile;
    @FXML
    private Tile leaderBoardTile;
    @FXML
    private Tile barChartTile;
    @FXML
    private GridPane tileGrid;
    @FXML
    private Tile radialChartTile;
    @FXML
    private Tile textTile;

    @FXML
    void startWorkout(ActionEvent event) {
        if (timer.isRunning()) {
            timer.stop();
        } else {
            timer.start();
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeGaugeSparkLineTile();
        initializeLeaderBoardTile();
        initializeBarChartTile();
        initializeRadialChartTile();
        initializeTextTile();
        System.out.println("Tile Should Be Built");
        lastTimerCall = System.nanoTime();
        lastLeaderBoard = System.nanoTime();
        timer = new StatusTimer() {
            @Override
            public void handle(long now) {

                if (now > lastTimerCall + 100_000_000) {
                    gaugeSparkLineTile.setValue(RND.nextDouble() * 100);
                    lastTimerCall = now;
                }
                if (now > lastLeaderBoard + 2_000_000_000) {
                    LeaderBoardItem leaderBoardItem1 = new LeaderBoardItem("Gerrit", RND.nextDouble() * 100);
                    leaderBoardTile.getLeaderBoardItems().add(leaderBoardItem1);
                    leaderBoardTile.setLeaderBoardItems(leaderBoardItem1);
                    BarChartItem barChartItem1 = new BarChartItem("Gerrit", RND.nextDouble() * 100, Tile.BLUE);
                    barChartTile.addBarChartItem(barChartItem1);
                    ChartData chartData1 = new ChartData("Item 1", RND.nextDouble() * 100, new RandomColor().getRandomColor());

                    radialChartTile.addChartData(chartData1);
                    System.out.println("leader board Item Added");
                    lastLeaderBoard = now;
                }

            }
        };
        tileGrid.add(gaugeSparkLineTile, 2, 2, 4, 4);
        tileGrid.add(radialChartTile, 6, 0, 2, 3);
        tileGrid.add(leaderBoardTile, 6, 3, 2, 3);
        tileGrid.add(barChartTile, 0, 0, 2, 3);
        tileGrid.add(textTile, 0,3,2,3);
    }

    public void initializeGaugeSparkLineTile() {
        gaugeSparkLineTile = TileBuilder.create()
                .skinType(SkinType.GAUGE_SPARK_LINE)
                .prefSize(TILE_SIZE, TILE_SIZE)
                .title("Velocity Gauge")
                .animated(true)
                .textVisible(true)
                .averagingPeriod(300)
                .autoReferenceValue(true)
                .barColor(Tile.YELLOW_ORANGE)
                .barBackgroundColor(Color.rgb(255, 255, 255, 0.1))
                .sections(new eu.hansolo.tilesfx.Section(0, 33, Tile.LIGHT_GREEN),
                        new eu.hansolo.tilesfx.Section(33, 67, Tile.YELLOW),
                        new eu.hansolo.tilesfx.Section(67, 100, Tile.LIGHT_RED))
                .sectionsVisible(true)
                .highlightSections(true)
                .strokeWithGradient(true)
                .gradientStops(new Stop(0.0, Tile.LIGHT_GREEN),
                        new Stop(0.33, Tile.LIGHT_GREEN),
                        new Stop(0.33, Tile.YELLOW),
                        new Stop(0.67, Tile.YELLOW),
                        new Stop(0.67, Tile.LIGHT_RED),
                        new Stop(1.0, Tile.LIGHT_RED))
                .build();
    }

    private void initializeLeaderBoardTile() {
        LeaderBoardItem leaderBoardItem1 = new LeaderBoardItem("Gerrit", RND.nextDouble() * 100);
        leaderBoardTile = TileBuilder.create()
                .prefSize(TILE_SIZE, TILE_SIZE)
                .skinType(SkinType.LEADER_BOARD)
                .title("LeaderBoard Tile")
                .text("Whatever text")
                .leaderBoardItems(leaderBoardItem1)
                .build();
    }

    private void initializeBarChartTile() {
        barChartTile = TileBuilder.create()
                .prefSize(TILE_SIZE, TILE_SIZE)
                .skinType(SkinType.BAR_CHART)
                .title("BarChart Tile")
                .text("Whatever text")
                .autoScale(true)
                .decimals(0)
                .build();
    }

    private void initializeRadialChartTile() {
        radialChartTile = TileBuilder.create()
                .skinType(SkinType.RADIAL_CHART)
                .prefSize(TILE_SIZE, TILE_SIZE)
                .title("Max Velocities")
                .textVisible(false)
                .build();
    }

    private void initializeTextTile() {
        textTile = TileBuilder.create()
                .prefSize(TILE_SIZE, TILE_SIZE)
                .skinType(SkinType.TEXT)
                .backgroundColor(Color.GREY)
                .title("Text Tile")
                .text("Whatever text")
                .description("May the force be with you\n...always")
                .textVisible(true)
                .build();
    }

}
