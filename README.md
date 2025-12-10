# 🎬 CFM Cinema  
Aplikasi Pemesanan Tiket Bioskop 

---

## 1. Deskripsi Project

CFM Cinema merupakan aplikasi desktop berbasis Java Swing yang mensimulasikan sistem pemesanan tiket bioskop.  
Aplikasi ini dikembangkan sebagai proyek Ujian Akhir Semester (UAS) Pemrograman Berorientasi Objek dengan tujuan menerapkan konsep OOP secara nyata, terstruktur, dan relevan dengan permasalahan dunia nyata.

Pengguna dapat:
- Melihat daftar film
- Memilih jadwal tayang
- Memilih kursi bioskop
- Melakukan pemesanan tiket
- Melihat riwayat pemesanan

---

## 2. Cara Menjalankan Program

1. Pastikan Java Development Kit (JDK) telah terinstal.
2. Buka project menggunakan NetBeans IDE atau IDE Java lainnya.
3. Pastikan struktur folder sebagai berikut:
```
src/
└── UAS/
    ├── MainApp.java
    ├── CinemaSystem.java
    ├── Booking.java
    ├── Movie.java
    ├── RegularMovie.java
    ├── PremiumMovie.java
    ├── Schedule.java
    ├── Seat.java
    └── images/bioskop.jpg
```

4. Jalankan file `MainApp.java`.
5. Aplikasi akan berjalan dalam bentuk GUI desktop.

---

## 3. Penjelasan GUI

### Home
Menampilkan halaman utama aplikasi dengan background bioskop dan teks sambutan.
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/ca19f3ea-589d-4fb9-961f-31a4733a3215" />

### Film
Menampilkan daftar film yang tersedia (Regular dan Premium).
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/74230c52-d2c7-4578-9bae-660b3cc9d1b5" />

### Schedule
Menampilkan jadwal tayang berdasarkan film yang dipilih.
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/acd70d5f-ead3-49fe-82f7-7ce345d88139" />

### Seat
Menampilkan kursi bioskop yang dapat dipilih oleh pengguna.
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/6ae3c083-33ce-4640-8d28-e2fb6d6022d3" />

### Booking
Digunakan untuk memasukkan nama pemesan dan melakukan pemesanan tiket.
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/b31a8efc-7eef-41cc-89cf-be4304e35a0c" />

### History
Menampilkan riwayat pemesanan tiket yang tersimpan di file.
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/38068023-09b4-4736-815b-4791c30fd087" />

---

## 4. Materi Sebelum UTS

### File I/O dan Exception Handling
Digunakan untuk menyimpan data pemesanan ke file booking.txt menggunakan BufferedWriter dan membaca data menggunakan BufferedReader.

Data pemesanan tetap tersimpan meskipun aplikasi ditutup.

---

## 5. Materi Setelah UTS (Non-GUI)

### Enkapsulasi
Diterapkan dengan penggunaan atribut private dan akses menggunakan getter dan setter.  
Contoh: Movie, Seat, Schedule, Booking.

### Inheritance & Polimorfisme
Class RegularMovie dan PremiumMovie mewarisi class Movie dan mengoverride method toString().

---

## 6. Screenshot Program
1. Class Movie
   <img width="1324" height="715" alt="Screenshot 2025-12-10 145308" src="https://github.com/user-attachments/assets/c22b16c6-2d0f-42e8-8847-1725091d752d" />
   
2. Class Regular Movie
   <img width="820" height="257" alt="image" src="https://github.com/user-attachments/assets/cf0cc789-62c3-48cd-8ca0-a64661efef60" />
   
3. Class Premmium Movie
   <img width="741" height="242" alt="image" src="https://github.com/user-attachments/assets/ebd93e40-54b9-4f98-8577-54d08c6f1e2d" />
   
4. Class Schedule
   <img width="1324" height="715" alt="Screenshot 2025-12-10 145308" src="https://github.com/user-attachments/assets/04e12ac5-00d1-4159-b033-018ab26407c0" />
   
5. Class Seat
   <img width="903" height="829" alt="image" src="https://github.com/user-attachments/assets/e4e86a7d-0207-4678-abfb-134f81ae7be5" />

7. Class Booking
   <img width="918" height="686" alt="image" src="https://github.com/user-attachments/assets/31bdeaa6-9274-427b-8b03-e334b0b0a00b" />
   
8. MainApp
   <img width="1013" height="788" alt="image" src="https://github.com/user-attachments/assets/5ef8977c-73e1-487c-b07c-531750305469" />
   
9. Cinema System
   <img width="903" height="829" alt="image" src="https://github.com/user-attachments/assets/aacb04d3-991a-4468-99fe-0e0daa780b72" />

## 7. Pembagian Tugas Anggota

Nama: Chisholun Najwa Salsabila (L0324009) 
Tugas:
- Perancangan sistem
- Implementasi OOP
  
Nama: Fizka Khairunnisa (L0324013)
- Pembuatan GUI 
- File I/O
  
Nama: Milla Agustin (L0324020)
- Perancangan sistem 
- Testing dan dokumentasi

---

## Kesimpulan

Aplikasi CFM Cinema berhasil dikembangkan sebagai simulasi sistem pemesanan tiket bioskop berbasis desktop menggunakan Java Swing. Program ini mampu mengintegrasikan antarmuka grafis yang interaktif dengan logika program yang terstruktur serta penyimpanan data secara permanen.

Melalui penerapan konsep Pemrograman Berorientasi Objek, seperti enkapsulasi, inheritance, dan polimorfisme, sistem dapat mengelola data film, jadwal, kursi, dan pemesanan secara efisien dan mudah dikembangkan. Selain itu, penggunaan File I/O dan Exception Handling memastikan data pemesanan tersimpan dengan aman dan tetap dapat diakses meskipun aplikasi ditutup.

Secara keseluruhan, aplikasi ini tidak hanya memenuhi kebutuhan fungsional sebagai sistem pemesanan tiket bioskop, tetapi juga berhasil menunjukkan implementasi teori OOP secara nyata, sistematis, dan relevan. Oleh karena itu, CFM Cinema layak digunakan sebagai media pembelajaran dan sebagai contoh penerapan Pemrograman Berorientasi Objek dalam pengembangan aplikasi desktop berbasis Java.
