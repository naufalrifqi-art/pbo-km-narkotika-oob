package app;

import controller.KnowledgeController;
import model.Putusan;
import model.StatistikPutusan;
import util.DataGenerator;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.util.ArrayList;

public class Main extends Application {

    private KnowledgeController controller;
    private ObservableList<Putusan> tableData;
    private TableView<Putusan> tableView;
    private Label footerLabel;

    @Override
    public void start(Stage primaryStage) {
        // Inisialisasi Controller
        // Inisialisasi Controller
        this.controller = new KnowledgeController();

// PANGGIL DATA GENERATOR DI SINI (Wajib agar tabel tidak kosong)
        DataGenerator.muatDataSampel(controller);

// ... kode JavaFX lainnya (TableView, dll) ...

        // --- ROOT CONTAINER (VBox) ---
        VBox root = new VBox();
        root.setMaxSize(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
        root.setMinSize(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
        root.setPrefSize(1000.0, 650.0);
        root.setSpacing(15.0);
        root.setStyle("-fx-background-color: #F8FAFC;");
        root.setPadding(new Insets(20.0, 20.0, 20.0, 20.0));

        // ==========================================
        // 1. HEADER
        // ==========================================
        HBox headerBox = new HBox();
        headerBox.setAlignment(Pos.CENTER_LEFT);
        headerBox.setSpacing(15.0);
        headerBox.setStyle("-fx-background-color: #1E293B; -fx-background-radius: 8; -fx-padding: 15;");

        VBox logoBox = new VBox();
        logoBox.setAlignment(Pos.CENTER);
        logoBox.setPrefSize(50.0, 50.0);
        logoBox.setStyle("-fx-background-color: #0EA5E9; -fx-background-radius: 6;");
        Label logoLabel = new Label("️");
        logoLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        logoLabel.setFont(new Font(24.0));
        logoBox.getChildren().add(logoLabel);

        VBox headerTextBox = new VBox();
        Label titleLabel = new Label("E-KMS Putusan Narkotika");
        titleLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        titleLabel.setFont(Font.font("System", FontWeight.BOLD, 18.0));
        headerTextBox.getChildren().addAll(titleLabel);
        headerBox.getChildren().addAll(logoBox, headerTextBox);

        // ==========================================
        // 2. KONTROL FITUR
        // ==========================================
        HBox controlBox = new HBox();
        controlBox.setAlignment(Pos.CENTER_LEFT);
        controlBox.setSpacing(20.0);
        controlBox.setStyle("-fx-background-color: white; -fx-padding: 12; -fx-background-radius: 8; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.05), 5, 0, 0, 1);");

        TextField searchField = new TextField();
        searchField.setPrefWidth(220.0);
        searchField.setPromptText("Cari nama terdakwa...");
        Button searchButton = new Button("Cari");
        searchButton.setStyle("-fx-background-color: #0EA5E9; -fx-text-fill: white; -fx-font-weight: bold;");

        ComboBox<String> filterComboBox = new ComboBox<>();
        filterComboBox.setPrefWidth(160.0);
        filterComboBox.setPromptText("Filter Pengadilan");
        filterComboBox.getItems().addAll("PN Surabaya", "PN Jakarta Selatan", "PN Bandung", "PN Semarang", "PN Medan");

        Button addButton = new Button("+ Tambah Data");
        addButton.setStyle("-fx-background-color: #10B981; -fx-text-fill: white;");
        Button statsButton = new Button("📊 Statistik");
        statsButton.setStyle("-fx-background-color: #6366F1; -fx-text-fill: white; -fx-font-weight: bold;");
        Button deleteButton = new Button("Hapus Terpilih");
        deleteButton.setStyle("-fx-background-color: #EF4444; -fx-text-fill: white;");

        controlBox.getChildren().addAll(searchField, searchButton, new Label(" | "), filterComboBox, addButton, statsButton, deleteButton);

        // ==========================================
        // 3. TABEL DATA (Terhubung ke Controller)
        // ==========================================
        tableView = new TableView<>();
        VBox.setVgrow(tableView, Priority.ALWAYS);
        tableView.setStyle("-fx-background-radius: 8;");

        // Setup Kolom (Binding ke Getter Putusan)
        setupColumn("Nomor Perkara", "nomorPerkara", 130);
        setupColumn("Pengadilan", "pengadilan", 120);
        setupColumn("Tanggal", "tanggalPutusan", 100);
        setupColumn("Nama Terdakwa", "namaTerdakwa", 140);
        setupColumn("Umur", "umurTerdakwa", 60);
        setupColumn("Jenis", "jenisNarkotika", 100);
        setupColumn("Berat (g)", "beratBarangBukti", 80);
        setupColumn("Pasal", "pasalDilanggar", 110);
        setupColumn("Peran", "peranTerdakwa", 90);
        setupColumn("Vonis (Bln)", "vonisHukuman", 90);
        setupColumn("Denda (Rp)", "vonisDenda", 110);
        setupColumn("Hakim", "namaHakim", 130);

        // Muat data awal ke tabel
        tableData = FXCollections.observableArrayList(controller.tampilkanSemua());
        tableView.setItems(tableData);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // ==========================================
        // 4. FOOTER
        // ==========================================
        HBox footerBox = new HBox();
        footerBox.setAlignment(Pos.CENTER_RIGHT);
        footerLabel = new Label("Total: " + tableData.size() + " Data Terinput");
        footerLabel.setTextFill(javafx.scene.paint.Color.web("#64748B"));
        footerBox.getChildren().add(footerLabel);

        // Gabungkan ke Root
        root.getChildren().addAll(headerBox, controlBox, tableView, footerBox);

        Scene scene = new Scene(root);
        primaryStage.setTitle("E-KMS Putusan Narkotika");
        primaryStage.setScene(scene);
        primaryStage.show();

        // ==========================================
        // 5. EVENT HANDLERS (Logika Controller)
        // ==========================================

        // Tombol Cari
        searchButton.setOnAction(e -> {
            String keyword = searchField.getText();
            if (!keyword.isEmpty()) {
                ArrayList<Putusan> hasil = controller.cariPutusan(keyword, "nama");
                tableData.setAll(hasil);
            } else {
                tableData.setAll(controller.tampilkanSemua());
            }
        });

        // Filter Pengadilan
        filterComboBox.setOnAction(e -> {
            String nilai = filterComboBox.getValue();
            if (nilai != null) {
                ArrayList<Putusan> hasil = controller.filterPutusan("pengadilan", nilai);
                tableData.setAll(hasil);
            }
        });

        // Tombol Hapus
        deleteButton.setOnAction(e -> {
            Putusan selected = tableView.getSelectionModel().getSelectedItem();
            if (selected != null) {
                controller.hapusPutusan(selected.getNomorPerkara());
                tableData.remove(selected);
                updateFooter();
            } else {
                showAlert(Alert.AlertType.WARNING, "Peringatan", "Pilih data di tabel terlebih dahulu!");
            }
        });

        // Tombol Tambah Data (Membuka Form Dialog)
        addButton.setOnAction(e -> tampilkanFormTambah(primaryStage));

        // Tombol Statistik
        statsButton.setOnAction(e -> {
            StatistikPutusan stat = controller.getStatistik();
            String konten = String.format(
                    "Total Putusan: %d\nRata-rata Vonis: %.2f Bulan\nRata-rata Denda: Rp %,.2f\nJenis Terbanyak: %s\nDistribusi Peran: %s",
                    stat.getTotalPutusan(), stat.getRataRataVonis(), stat.getRataRataDenda(),
                    stat.getJenisNarkotikaTerbanyak(), stat.getDistribusiPeran()
            );
            showAlert(Alert.AlertType.INFORMATION, "Laporan Statistik", konten);
        });
    }

    // Helper untuk membuat kolom tabel
    private void setupColumn(String title, String property, double width) {
        TableColumn<Putusan, Object> col = new TableColumn<>(title);
        col.setCellValueFactory(new PropertyValueFactory<>(property));
        col.setPrefWidth(width);
        tableView.getColumns().add(col);
    }

    // Helper untuk update footer
    private void updateFooter() {
        footerLabel.setText("Total: " + tableData.size() + " Data Terinput");
    }

    // Helper untuk menampilkan Alert
    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    // Form Tambah Data Sederhana
    private void tampilkanFormTambah(Stage owner) {
        Stage dialog = new Stage();
        dialog.initOwner(owner);
        dialog.setTitle("Tambah Putusan Baru");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(15));
        grid.setHgap(10);
        grid.setVgap(10);

        TextField[] fields = new TextField[12];
        String[] labels = {"Nomor Perkara", "Pengadilan", "Tanggal", "Nama Terdakwa", "Umur", "Jenis Narkotika", "Berat (gram)", "Pasal", "Peran", "Vonis (Bulan)", "Denda (Rp)", "Nama Hakim"};

        for (int i = 0; i < 12; i++) {
            grid.add(new Label(labels[i]), 0, i);
            fields[i] = new TextField();
            fields[i].setPrefWidth(250);
            grid.add(fields[i], 1, i);
        }

        Button btnSimpan = new Button("Simpan");
        btnSimpan.setStyle("-fx-background-color: #10B981; -fx-text-fill: white;");
        btnSimpan.setOnAction(e -> {
            String[] data = new String[12];
            for (int i = 0; i < 12; i++) data[i] = fields[i].getText();

            boolean sukses = controller.tambahPutusan(data);
            if (sukses) {
                tableData.setAll(controller.tampilkanSemua());
                updateFooter();
                dialog.close();
            } else {
                showAlert(Alert.AlertType.ERROR, "Gagal", "Data tidak valid! Pastikan format angka benar dan tidak ada yang kosong.");
            }
        });

        grid.add(btnSimpan, 1, 12);
        dialog.setScene(new Scene(grid));
        dialog.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}