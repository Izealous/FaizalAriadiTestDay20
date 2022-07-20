Feature: Check Out Aplikasi Payment Gateway

	Scenario: Check Out barang dengan data valid
		Given User di halaman payment "https://demo.guru99.com/payment-gateway/index.php"
		When User memasukkan jumlah beli
		And User menekan tombol buy dan sistem memprosesnya
		And User berada di halaman "Payment Process"
		And User memasukkan nomer kartu "4444444444444444"
		And User memilih bulan
		And User memilih tahun
		And User memasukkan cvv code "412"
		And User menekan tombol pay dan sistem memprosesnya
		Then User harus berada di halaman "Payment successfull!"