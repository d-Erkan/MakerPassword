import java.util.Scanner;
 
public class PasswordMaker{
 
        private String str;
        private String strNoSpace;    // bosluklari kaldirilmis string
        public String sifrelenmisStr;
        private int N;                // karakter sayisi
        private int row, column;      // R ve C
        private int kucukSayi, buyukSayi; // alt limit, ust limit
        private char[][] array;
        private int rowColumnCarpim;  // R*C sayisi
 
 
    public void readInput()
    {
        System.out.print("Stringi giriniz: ");
        Scanner kb = new Scanner(System.in);
        str = kb.nextLine();
    }
 
    public void removeSpace()
    {
        strNoSpace = str.replace(" ","");
        // System.out.println("bosluklar kaldirilmis str = " + strNoSpace);
    }
 
    public void findLimitValues()
    {
        N = strNoSpace.length();                    // N = bosluksuz stringin karakter sayisi
        kucukSayi = (int) Math.floor(Math.sqrt(N)); // Math class ile alt limit, ust limit bulunur
        buyukSayi = (int) Math.ceil(Math.sqrt(N));
    }
 
    public void findRowAndColumn()
    {
          row = kucukSayi; column = kucukSayi;      // satir ve sutun sayisi, alt limit degere esitlenir.
          rowColumnCarpim = row*column;             // R*C degeri hesaplanir.
 
          if(rowColumnCarpim < N)                   // eger R*C, karakter sayisindan kucukse once sutun sayisi 1 artar.
            column++;
            rowColumnCarpim = row*column;           // yeni R*C bulunur.
 
          if(rowColumnCarpim < N)                   // hala R*C, karakter sayisindan kucukse satir sayisi 1 artar.
              row++;
           
            // bunu basitce if ile yazabilmemin sebebi alt ve ust limit sayilarinin ardisik olmasidir.
            // yani satir ve sutunu en fazla birer kez artirmak yetecektir.
              System.out.println(row);
              System.out.println(column);
/**boolean b1 = ((kucukSayi<= row) && (buyukSayi >= row)); boolean b2 = ((kucukSayi<= column) && (buyukSayi >= column));
      gibi bir kontrole gerek yok, yukaridaki metot ile sayi limitler arasinda kaliyor.
    */
 
    }
 
 
    public void moveStringtoArray()
    {
      array = new char [row][column];
 
      for (int i = 0; i < row; i++)
      {
          for (int j = 0; j < column; j++)
          {
            array[i][j] = ' ';
          }
      }
 
      int indexAtStr = 0;

      for (int i = 0; i< row; i++)
      {
          for (int j=0; j < column; j++)
          {
            while (indexAtStr < N)
            {
              array[i][j] = strNoSpace.charAt(indexAtStr);
              indexAtStr ++;
            }
          }
      }
 
    /**   for (int i = 0; i < row; i++)
      {
          for (int j = 0; j < column; j++)
          {
            System.out.println(array[i][j]);
          }
      }
      */
 
    }
 
    public void sifrele()
    {
  //  moveStringtoArray();
  sifrelenmisStr = "aman";
      for (int j = 0; j < column; j++)
      {
        for (int i = 0; i< row; i++)
        {
 
            //sifrelenmisStr += "" + array[i][j];
            //for (String sifrelenmisStr : array)
            System.out.println(sifrelenmisStr);
            sifrelenmisStr = sifrelenmisStr + array[i][j];
        }
        sifrelenmisStr = sifrelenmisStr.trim();
        sifrelenmisStr = sifrelenmisStr + " ";
      }
     // sifrelenmisStr = sifrelenmisStr.trim();
    }
 
 
    public void writeOutput()
    {
        System.out.println("Sifreniz: " + sifrelenmisStr);
    }
}
 
