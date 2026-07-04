# Knowledge Management System Putusan Pengadilan Narkotika

## Deskripsi Proyek
Aplikasi berbasis Java (JDK 11+) dengan arsitektur MVC untuk mengelola data putusan pengadilan pidana narkotika. Aplikasi ini memungkinkan pengguna untuk melakukan CRUD data, pencarian, filter, dan melihat statistik ringkas dari dataset putusan.

## Anggota Kelompok
|          Nama         |       NIM       | Kelas |         Peran         |            Git Branch            |
|-----------------------|-----------------|-------|-----------------------|----------------------------------|
|       Naufal Rifqi    | 202510370110096 |   2A  |  Controller Engineer  | `feature/controller` & `develop` |
|       GST. Nouval     | 202510370110229 |   2A  | Knowledge/DB Engineer |         `feature/model`          |
| M. Fahri Aulia Rahman | 202510370110005 |   2A  |      GUI Designer     |          `feature/view`          |

## Cara Kompilasi & Menjalankan
1. Pastikan Java JDK 11+ sudah terinstal
2. Clone repository: `git clone https://github.com/naufalrifqi-art/pbo-km-narkotika-oob.git`
3. Buka project di IDE (IntelliJ IDEA / Eclipse / NetBeans)
4. Jalankan class `app.Main`

## Struktur Package (MVC)
- `app/` : Entry point (Main.java)
- `model/` : Putusan.java, KnowledgeRepository.java, StatistikPutusan.java
- `view/` : ConsoleView.java / JavaFX View
- `controller/` : KnowledgeController.java
- `util/` : InputHandler.java

## Video Demo
[Link Video Demo YouTube] *(akan diupdate sebelum deadline)*
