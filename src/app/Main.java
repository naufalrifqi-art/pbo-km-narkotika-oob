package app;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        // --- ROOT CONTAINER (VBox) ---
        VBox root = new VBox();
        root.setMaxSize(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
        root.setMinSize(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
        root.setPrefSize(1000.0, 650.0);
        root.setSpacing(15.0);
        root.setStyle("-fx-background-color: #F8FAFC;");
        root.setPadding(new Insets(20.0, 20.0, 20.0, 20.0));

        // ==========================================
        // 1. HEADER & LOGO BARU
        // ==========================================
        HBox headerBox = new HBox();
        headerBox.setAlignment(Pos.CENTER_LEFT);
        headerBox.setSpacing(15.0);
        headerBox.setStyle("-fx-background-color: #1E293B; -fx-background-radius: 8; -fx-padding: 15;");

        // Placeholder Logo
        VBox logoBox = new VBox();
        logoBox.setAlignment(Pos.CENTER);
        logoBox.setPrefSize(50.0, 50.0);
        logoBox.setStyle("-fx-background-color: #0EA5E9; -fx-background-radius: 6;");

        Label logoLabel = new Label("⚖️");
        logoLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        logoLabel.setFont(new Font(24.0));
        logoBox.getChildren().add(logoLabel);

        // Info Teks Header
        VBox headerTextBox = new VBox();
        Label titleLabel = new Label("E-KMS Putusan Narkotika");
        titleLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        titleLabel.setFont(Font.font("System", FontWeight.BOLD, 18.0));


        headerTextBox.getChildren().addAll(titleLabel);
        headerBox.getChildren().addAll(logoBox, headerTextBox);

        // ==========================================
        // 2. KONTROL FITUR (SEARCH, FILTER, ACTION)
        // ==========================================
        HBox controlBox = new HBox();
        controlBox.setAlignment(Pos.CENTER_LEFT);
        controlBox.setSpacing(20.0);
        controlBox.setStyle("-fx-background-color: white; -fx-padding: 12; -fx-background-radius: 8; " +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.05), 5, 0, 0, 1);");

        // Fitur Pencarian Tunggal
        HBox searchBox = new HBox();
        searchBox.setAlignment(Pos.CENTER_LEFT);
        searchBox.setSpacing(8.0);

        TextField searchField = new TextField();
        searchField.setPrefWidth(220.0);
        searchField.setPromptText("Cari nama terdakwa atau nomor...");
        searchField.setStyle("-fx-background-radius: 4;");

        Button searchButton = new Button("Cari");
        searchButton.setMnemonicParsing(false);
        searchButton.setStyle("-fx-background-color: #0EA5E9; -fx-text-fill: white; -fx-font-weight: bold;");
        searchBox.getChildren().addAll(searchField, searchButton);

        // Filter Sederhana (Hanya Pengadilan)
        HBox filterBox = new HBox();
        filterBox.setAlignment(Pos.CENTER_LEFT);
        filterBox.setSpacing(8.0);

        Label filterLabel = new Label("Pengadilan:");
        filterLabel.setTextFill(javafx.scene.paint.Color.web("#475569"));

        ComboBox<String> filterComboBox = new ComboBox<>();
        filterComboBox.setPrefWidth(160.0);
        filterComboBox.setPromptText("Semua Pengadilan");
        filterBox.getChildren().addAll(filterLabel, filterComboBox);

        // Tombol Aksi Utama (Ditambahkan Button Statistik Sesuai Dokumen Modul)
        HBox actionBox = new HBox();
        actionBox.setAlignment(Pos.CENTER_LEFT);
        actionBox.setSpacing(10.0);
        actionBox.setPadding(new Insets(0, 0, 0, 20.0));
        HBox.setHgrow(actionBox, Priority.ALWAYS); // HBox.hgrow="ALWAYS"

        Button addButton = new Button("+ Tambah Data");
        addButton.setMnemonicParsing(false);
        addButton.setStyle("-fx-background-color: #10B981; -fx-text-fill: white;");

        // BUTTON STATISTIK BARU (Menggunakan warna Indigo/Ungu profesional)
        Button statsButton = new Button("📊 Statistik");
        statsButton.setMnemonicParsing(false);
        statsButton.setStyle("-fx-background-color: #6366F1; -fx-text-fill: white; -fx-font-weight: bold;");

        Button deleteButton = new Button("Hapus");
        deleteButton.setMnemonicParsing(false);
        deleteButton.setStyle("-fx-background-color: #EF4444; -fx-text-fill: white;");

        // Menyusun tombol aksi baru
        actionBox.getChildren().addAll(addButton, statsButton, deleteButton);

        // Masukkan semua ke dalam baris kontrol
        controlBox.getChildren().addAll(searchBox, filterBox, actionBox);

        // ==========================================
        // 3. TABEL DATA (TableView)
        // ==========================================
        TableView tableView = new TableView();
        VBox.setVgrow(tableView, Priority.ALWAYS); // VBox.vgrow="ALWAYS"
        tableView.setStyle("-fx-background-radius: 8;");

        // Inisialisasi Kolom tanpa Wildcard <?,?>
        TableColumn colNoPerkara = new TableColumn("Nomor Perkara");
        colNoPerkara.setPrefWidth(130.0);

        TableColumn colPengadilan = new TableColumn("Pengadilan");
        colPengadilan.setPrefWidth(120.0);

        TableColumn colTglPutusan = new TableColumn("Tanggal Putusan");
        colTglPutusan.setPrefWidth(110.0);

        TableColumn colNamaTerdakwa = new TableColumn("Nama Terdakwa");
        colNamaTerdakwa.setPrefWidth(140.0);

        TableColumn colUmur = new TableColumn("Umur");
        colUmur.setPrefWidth(60.0);

        TableColumn colJenisNarkotika = new TableColumn("Jenis Narkotika");
        colJenisNarkotika.setPrefWidth(120.0);

        TableColumn colBerat = new TableColumn("Berat (g)");
        colBerat.setPrefWidth(90.0);

        TableColumn colPasal = new TableColumn("Pasal Dilanggar");
        colPasal.setPrefWidth(120.0);

        TableColumn colVonis = new TableColumn("Vonis");
        colVonis.setPrefWidth(110.0);

        // Tambahkan kolom ke tabel
        tableView.getColumns().addAll(
                colNoPerkara, colPengadilan, colTglPutusan, colNamaTerdakwa,
                colUmur, colJenisNarkotika, colBerat, colPasal, colVonis
        );

        // Policy Resize Kolom
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // ==========================================
        // 4. FOOTER
        // ==========================================
        HBox footerBox = new HBox();
        footerBox.setAlignment(Pos.CENTER_RIGHT);

        Label footerLabel = new Label("Total: 0 Data Terinput");
        footerLabel.setTextFill(javafx.scene.paint.Color.web("#64748B"));
        footerLabel.setFont(new Font(12.0));
        footerBox.getChildren().add(footerLabel);

        // ==========================================
        // GABUNGKAN SEMUA KE ROOT & ATUR SCENE
        // ==========================================
        root.getChildren().addAll(headerBox, controlBox, tableView, footerBox);

        Scene scene = new Scene(root);
        primaryStage.setTitle("E-KMS Putusan Narkotika");
        primaryStage.setScene(scene);
        primaryStage.show();

        // --- EVENT HANDLER PLACEHOLDER UNTUK STATISTIK ---
        statsButton.setOnAction(e -> {
            // Ini adalah pop-up/alert penampung laporan statistik sesuai spesifikasi bab 5 dokumen
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Laporan Statistik Putusan Narkotika");
            alert.setHeaderText("KMS Ringkasan Statistik");
            alert.setContentText(
                    "Total Putusan: 0\n" +
                            "Rata-rata Vonis: 0.0 Bulan\n" +
                            "Rata-rata Denda: Rp 0.0\n" +
                            "Jenis Narkotika Terbanyak: -\n" +
                            "Distribusi Peran: -"
            );
            alert.showAndWait();
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}