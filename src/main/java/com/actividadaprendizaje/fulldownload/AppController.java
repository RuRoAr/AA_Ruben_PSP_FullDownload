package com.actividadaprendizaje.fulldownload;

import com.svalero.multihilo.util.R;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;


public class AppController {

    public TextField tfUrl;
    public Button btDownload;
    public TabPane tpDownloads;

    public AppController() {

    }

    @FXML
    public void launchDownload(ActionEvent event) {
        String urlText = tfUrl.getText();
        tfUrl.clear();
        tfUrl.requestFocus();

        launchDownload(urlText);
    }

    private void launchDownload(String url) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(R.getUI("download.fxml"));

            com.svalero.multihilo.DownloadController downloadController = new com.svalero.multihilo.DownloadController(url);
            loader.setController(downloadController);
            VBox downloadBox = loader.load();

            String filename = url.substring(url.lastIndexOf("/") + 1);
            tpDownloads.getTabs().add(new Tab(filename, downloadBox));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    @FXML
    public void stopAllDownloads() {
    }

    @FXML
    public void readDLC() {
    }
}
