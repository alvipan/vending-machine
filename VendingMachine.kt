fun main() {
    val vm = VendingMachine()
    vm.beli(vm.items[1], 2, 50000)
}

class VendingMachine {

    val items = mutableListOf<Item>()
    val allowedCash = listOf(2000, 5000, 10000, 20000, 50000)
    
    init {
        items.add(Item("Biskuit", 6000, 10))
        items.add(Item("Chips", 8000, 5))
        items.add(Item("Oreo", 10000, 0))
        items.add(Item("Tango", 12000, 3))
        items.add(Item("Cokelat", 15000, 6))
    }
    
    // Memeriksa apakah pecahan uang diterima oleh mesin
    fun cekUang(uang: Int): Boolean {
        return allowedCash.contains(uang)
    }
    
    // Memeriksa stok item
    fun cekStok(item: Item): Int {
        return item.stok
    }
    
    // Fungsi pembelian
    fun beli(item: Item, jumlah: Int, uang: Int) {
	if (!cekUang(uang)) return print("Maaf, pecahan uang tidak diterima.")
        if (cekStok(item) < jumlah) return print("Maaf, stok tidak cukup.")
        if (uang < (item.harga * jumlah)) return print("Maaf, uang anda tidak mencukupi.")
        
        items[items.indexOf(item)].stok -= jumlah
        if (uang > (item.harga * jumlah)) kembali(uang - (item.harga * jumlah))
        cetakStruk(item, jumlah, uang)
    }
    
    // Fungsi pengembalian uang
    fun kembali(nominal: Int): Int {
	return nominal
    }
    
    fun cetakStruk(item: Item, jumlah: Int, uang: Int) {
        println("Pembelian Berhasil\n")
        println("Nama item    : ${item.nama}")
        println("Harga item   : ${item.harga}")
        println("Jumlah item  : ${jumlah}")
        println("-------------------------")
        println("Total harga  : ${item.harga * jumlah}")
        println("Bayar        : ${uang}")
        println("Kembali      : ${uang - (item.harga * jumlah)}")
    }
}

data class Item(val nama: String, val harga: Int, var stok: Int) {}
