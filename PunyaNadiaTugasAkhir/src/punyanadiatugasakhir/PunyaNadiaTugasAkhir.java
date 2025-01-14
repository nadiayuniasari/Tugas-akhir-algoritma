package punyanadiatugasakhir;
import java.io.*;
import java.util.*;

public class PunyaNadiaTugasAkhir {

    static boolean running = true;
    static ArrayList<Object[]> listData = new ArrayList();
    static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException {
        do {            
            menu();
        } while (running);
    }
    
    static void menu() throws IOException {
        System.out.println("----------------------------------------------- ");
        System.out.println("           PROGRAM BENGKEL MOTOR                ");
        System.out.println(" NIM : 24.2400.0023 Nama : Nadia yuniasari      ");
        System.out.println("------------------------------------------------");
        
        System.out.println("=== MENU UTAMA ===");
        System.out.println("1. Isi Data");
        System.out.println("2. Lihat Laporan");
        System.out.println("3. Cetak Struk");
        System.out.println("4. Koreksi/Edit Data");
        System.out.println("5. Hapus Data");
        System.out.println("6. Selesai");
        System.out.println();
        
        System.out.print("Masukkan pilihan menu (1-5): ");
        int pilihan = input.nextInt();
        input.nextLine();

        switch (pilihan) {
            case 1:
                isiData();
                break;
            case 2:
                lihatLaporan();
                break;
            case 3:
                cetakStruk();
                break;
            case 4:
                editData();
                break;
            case 5:
                removeData();
                break;
            case 6:
                System.out.println("Terima kasih telah menggunakan program ini.");
                System.exit(0);
                break;
            default:
                System.out.println("Pilihan menu tidak valid. Silakan coba lagi.");
                System.out.println();
                menu();
                break;
        }
    }
    
    static void isiData() throws IOException {
        System.out.println();
        
        System.out.print("Nama Customer : ");
        String namaCustomer = input.nextLine();
                
        System.out.print("No STNK : ");
        String stnkCustomer = input.nextLine();
        
        System.out.println("\n===============PILIH SERVIS===============");
        System.out.println("1. Ganti Oli Mesin : 100000");
        System.out.println("2. Ganti Komstir   : 500000");
        System.out.println("3. Ganti Kampas Rem: 70000");
        System.out.println("4. Ganti Lampu Bolam : 30000");
        System.out.println("5. Ganti Oli Garden  : 200000");
        System.out.println("6. Ganti Ban Tubles  : 400000");
        
        System.out.print("\nIsikan Data [1-6] : ");
        int pilihPaket = input.nextInt();
        
        String paketServis = null;
        double hargaServis = 0;
        
        switch (pilihPaket) {
            case 1:
                paketServis = "Ganti Oli Mesin";
                hargaServis = 100000;
                break;
            case 2:
                paketServis = "Ganti Komstir";
                hargaServis = 500000;
                break;
            case 3:
                paketServis = "Ganti Kampas Rem";
                hargaServis = 70000;
                break;
            case 4:
                paketServis = "Ganti Lampu Bolam";
                hargaServis = 30000;
                break;
            case 5:
                paketServis = "Ganti Oli Garden";
                hargaServis = 200000;
                break;
            case 6:
                paketServis = "Ganti Ban Tubles";
                hargaServis = 400000;
                break;
            default:
                System.out.println("Pilihan paket tidak valid.");
                menu();
        }
        
        System.out.print("Masukkan Jumlah Diskon : ");
        double diskonInput = input.nextDouble();
        
        double diskon;
        
        if (diskonInput >= 0 && diskonInput <= 100) {
            diskon = (int) (hargaServis * diskonInput / 100);
        } else {
            System.out.println("Diskon harus berada dalam rentang 0-100%. Diskon diatur ke 0%.");
            diskon = 0;
        }

        double totalPembayaran = hargaServis - diskon;

        Object[] listCustomerData = {namaCustomer,
                                    stnkCustomer,
                                    paketServis,
                                    hargaServis,
                                    diskon,
                                    totalPembayaran};
        listData.add(listCustomerData);
        
        input.nextLine();
        System.out.print("Apakah Anda ingin mengisi data lagi? [y/t] : ");
        String jawab = input.nextLine();
        if ("y".equalsIgnoreCase(jawab)) {
            isiData();
        } else {
            menu();
        }
        
}
    
    static void lihatLaporan() throws IOException {
        if (listData.isEmpty()) {
            System.out.println("Data masih kosong! Silahkan isi terlebih dahulu. :)");
        } else {
            System.out.println("LAPORAN PENJUALAN SERVIS BENGKEL HONDA");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("| %-2s | %-16s | %-17s | %-29s | %-15s | %-16s | %-23s |\n","NO","NAMA","STNK","PAKET SERVIS","HARGA","DISKON","TOTAL PEMBAYARAN");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
            
            double grandTotal = 0;
            
            for (int i = 0; i < listData.size(); i++) {
                Object[] dataCustomer = listData.get(i);
                grandTotal += (double) dataCustomer[5];
                System.out.printf("| %-2d | %-16s | %17s | %-29s | %15.2f | %16.2f | %23.2f |\n",
                    i + 1,
                    dataCustomer[0],
                    dataCustomer[1],
                    dataCustomer[2],
                    dataCustomer[3],
                    dataCustomer[4],
                    dataCustomer[5]);
            }
            
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("| %-110s | %23.2f |\n","Total", grandTotal);
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }
    
    static void cetakStruk() throws IOException {
        
        lihatLaporan();
        System.out.print("Pilih data yang ingin dicetak : ");
        int datapilih = input.nextInt()-1;
        Object[] dataStruk = listData.get(datapilih);
        
        System.out.println("\nBENGKEL HONDA");
        System.out.println("WA - 08XX XXXX XXXX");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("NAMA : "+dataStruk[0]);
        System.out.println("STNK : "+dataStruk[1]);
        System.out.println("-----------------------------------------------------------------");
        System.out.printf("| %2s | %18s | %9s | %8s | %12s |%n", "NO", "NAMA BARANG/SERVIS", "HARGA", "DISKON", "JML. HARGA");
        System.out.println("-----------------------------------------------------------------");
        System.out.printf("| %2s | %18s | %9s | %8s | %12s |%n", 1, dataStruk[2], dataStruk[3], dataStruk[4], dataStruk[5]);
        System.out.println("-----------------------------------------------------------------\n");
    }
    
    static void editData() throws IOException {
        lihatLaporan(); 
        System.out.print("Masukkan nomor data yang akan diedit : ");
        int nomorData = input.nextInt()-1;
        
        Object[] listDataCustomer = listData.get(nomorData);
        
        input.nextLine();
        System.out.print("Nama Customer baru : ");
        String namaCustomer = input.nextLine();
        listDataCustomer[0] = namaCustomer;
        
        System.out.print("STNK baru: ");
        String stnkCustomer = input.nextLine();
        listDataCustomer[1] = stnkCustomer;
        
        System.out.println("===============PILIH SERVIS===============");
        System.out.println("\t1. Ganti Oli Mesin : 100000");
        System.out.println("\t2. Ganti Komstir   : 500000");
        System.out.println("\t3. Ganti Kampas Rem: 70000");
        System.out.println("\t4. Ganti Lampu Bolam : 30000");
        System.out.println("\t5. Ganti Oli Garden  : 200000");
        System.out.println("\t6. Ganti Ban Tubles  : 400000");
        
        System.out.print("Pilih paket baru [1-6] : ");
        int pilihPaket = input.nextInt();
        
        switch (pilihPaket) {
            case 1:
                listDataCustomer[2] = "Ganti Oli Mesin";
                listDataCustomer[3] = (double) 100000;
                break;
                
            case 2:
                listDataCustomer[2] = "Ganti Komstir";
                listDataCustomer[3] = (double) 500000;
                break;
                
            case 3:
                listDataCustomer[2] = "Ganti Kampas Rem";
                listDataCustomer[3] = (double) 70000;
                break;
            
            case 4:
                listDataCustomer[2] = "Ganti Lampu Bolam";
                listDataCustomer[3] = (double) 30000;
                break;
                
            case 5:
                listDataCustomer[2] = "Ganti Oli Garden";
                listDataCustomer[3] = (double) 200000;
                break;
                
            case 6:
                listDataCustomer[2] = "Ganti Ban Tunbles";
                listDataCustomer[3] = (double) 400000;
                break;
                
            default:
                System.out.println("Pilihan paket tidak valid.");
                return;
        }
        
        System.out.print("Masukkan Jumlah Diskon Baru : ");
        double diskonInput = input.nextDouble();
        
        double diskon;
        if (diskonInput >= 0 && diskonInput <= 100) {
            diskon = ((double)listDataCustomer[3] * diskonInput / 100);
        } else {
            System.out.println("Diskon harus berada dalam rentang 0-100%. Diskon diatur ke 0%.");
            diskon = 0;
        }

        double totalPembayaran = (double) listDataCustomer[3] - diskon;
        
        listDataCustomer[4] = diskon;
        listDataCustomer[5] = totalPembayaran;
    }
    
    static void removeData() throws IOException {
        if (listData.isEmpty()) {
            System.out.println("Tidak bisa menghapus, Data masih kosong!");
            menu();
        } else {
            lihatLaporan();
            System.out.println("Pilih data yang ingin di hapus.");
            System.out.print(">>> ");
            int indexRemoveData = input.nextInt()-1;
            
            if (indexRemoveData < 0 || indexRemoveData >= listData.size()) {
                System.out.println("Anggota tidak valid. Silakan coba lagi.");
                menu();
            } else {
                listData.remove(indexRemoveData);
            }
            menu();
        }
    }
}