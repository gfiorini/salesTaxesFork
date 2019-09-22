# salesTaxes

Exercise input is provided hardcoded in unit test class TestSalesTaxes, input data is cointained in class Cart

testReceipt1 validates exercise Input/Output 1 

testReceipt2 validates exercise Input/Output 2

testReceipt3 validates exercise Input/Output 3

(I changed input 3 line "box of imported chocolates" to "imported box of chocolates" because i think it is a typo)

Every testReceipt test call receiptManager.calculateReceipt(Cart) and generates a Receipt object 
which is printed to console and validated against expected output files (output_1.txt, output_2.txt, output_3.txt)

The solution works correctly against this data 