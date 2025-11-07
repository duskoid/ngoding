import java.util.HashMap;
import java.util.Map;

/* TODO: Lengkapi class Library dengan member management dan exception handling kompleks

   Fields:
   - books (Book[]): array untuk menyimpan buku
   - bookCount (int): jumlah buku saat ini
   - members (Map<String, Member>): HashMap untuk menyimpan member (key: memberId)

   

   Methods:

   1. 

   2. 

   3. 

   4. 

   5. 

   6. 

   7. 

   8. 

   9. 

   10. 

   11. int getBookCount(): return bookCount
   12. int getMemberCount(): return members.size()

   HINTS:
   - Gunakan multi-catch untuk menangkap beberapa exception types
   - try-catch-finally memastikan cleanup code berjalan
   - Finally block berjalan bahkan jika ada exception
   - Throw LibraryException sebagai parent untuk polimorfisme
*/

public class Library {
    // TODO: Implement all methods with proper exception handling
  private Book[] books;
	private int bookCount;
	private Map<String, Member> members;

	public Library(int capacity){
    /*Constructor:
   - Library(int capacity)
     * Inisialisasi books array dengan size capacity
     * Set bookCount = 0
     * Inisialisasi members sebagai new HashMap<>() */
		books = new Book[capacity];
		bookCount = 0;
		members = new HashMap<>();
	}

	public void addBook(Book b){
    /*void addBook(Book book)
      * Jika book null: throw NullPointerException
      * Jika bookCount >= books.length: throw IllegalStateException
      * Tambah book ke array, increment bookCount */
		if (b == null){
			throw new NullPointerException(); 
		}
		if (bookCount >= books.length){
			throw new IllegalStateException();
		}
		books[bookCount] = b;
		bookCount++;
	}

	public void registerMember(Member m) throws LibraryException{
    /*void registerMember(Member member) throws LibraryException
      * Jika member null: throw LibraryException dengan errorCode "INVALID_MEMBER"
      * Jika members.containsKey(member.getMemberId()): throw LibraryException dengan errorCode "DUPLICATE_MEMBER"
      * members.put(member.getMemberId(), member) */
		if (m == null) throw new LibraryException("woilah", "INVALID_MEMBER");
		if (members.containsKey(m.getMemberId())) throw new LibraryException("woilah", "DUPLICATE_MEMBER");
		members.put(m.getMemberId(), m);
	}

	public Member findMember(String memberId) throws LibraryException{
    /*Member findMember(String memberId) throws LibraryException
      * Jika memberId null/kosong: throw LibraryException dengan errorCode "INVALID_MEMBER"
      * Get member dari map
      * Jika null: throw LibraryException dengan errorCode "MEMBER_NOT_FOUND"
      * Return member */
		if (memberId == null || memberId.isEmpty()) throw new LibraryException("Woi", "INVALID_MEMBER");
		Member mem = members.get(memberId);
		if (mem == null) throw new LibraryException("Woilahcik", "MEMBER_NOT_FOUND");
		return mem;
	}

	public Book findBook(String title){
    /*Book findBook(String title)
      * Jika title null: return null
      * Loop books array, bandingkan dengan equalsIgnoreCase
      * Return book jika ditemukan, null jika tidak */
		if (title == null) return null;
		for (Book b : books){
			if (b.getTitle().equalsIgnoreCase(title)){
        return b;
      }
		}
    return null;
	}

  public void borrowBook(String memberId, String bookTitle) throws LibraryException{
    /* PENTING: Method ini harus menggunakan try-catch-finally!

      * Declare: Member member = null, Book book = null
      * Try block:
        - member = findMember(memberId)
        - book = findBook(bookTitle)
        - Jika book == null: throw BookNotAvailableException (buku tidak ditemukan)
        - member.borrowBook(bookTitle) - ini bisa throw LibraryException
        - book.borrowBook() - ini bisa throw BookNotAvailableException

      * Catch blocks (PENTING: Gunakan dua catch blocks terpisah, bukan multi-catch, karena BookNotAvailableException adalah subclass dari LibraryException):
        catch (BookNotAvailableException e)
        - Re-throw exception
        catch (LibraryException e)
        - Re-throw exception

      * Finally block:
        - WAJIB PRINT: "Transaction attempt completed for: " + member.getName()
        - Hanya print jika member != null
        - Format EXACT: "Transaction attempt completed for: <nama member tanpa <> >"
        - Contoh: "Transaction attempt completed for: Alice Johnson" */
    Member m = null;
    Book b = null;

    try{
      m = findMember(memberId);
      b = findBook(bookTitle);
      if (b == null) throw new BookNotAvailableException("buku tidak ditemukan");
      m.borrowBook(bookTitle);
      b.borrowBook();
    } catch (BookNotAvailableException e){
      throw e;
    } catch (LibraryException e){
      throw e;
    } finally {
      if (m != null){
        System.out.println("Transaction attempt completed for: " + m.getName());
      }
    }
  }

  public void returnBook(String memberId, String bookTitle) throws LibraryException{
      /*PENTING: Gunakan try-catch-finally pattern seperti borrowBook!

      * Declare: Member member = null, Book book = null
      * Try:
        - member = findMember(memberId)
        - book = findBook(bookTitle)
        - Jika book == null: throw InvalidBookException
        - member.returnBook(bookTitle)
        - book.returnBook()

      * Catch blocks (PENTING: Gunakan dua catch blocks terpisah):
        catch (InvalidBookException e)
        - Re-throw
        catch (LibraryException e)
        - Re-throw

      * Finally:
        - WAJIB PRINT: "Return transaction completed for: " + member.getName()
        - Hanya print jika member != null
        - Format EXACT: "Return transaction completed for: <nama member tanpa <> >"
        - Contoh: "Return transaction completed for: Bob Smith"*/
    Member m = null;
    Book b = null;
    try {
      m = findMember(memberId);
      b = findBook(bookTitle);
      if (b == null) throw new InvalidBookException("buku tidak ada");
      m.returnBook(bookTitle);
      b.returnBook();
    } catch (InvalidBookException e){
      throw e;
    } catch (LibraryException e){
      throw e;
    } finally {
      if (m != null){
        System.out.println("Return transaction completed for: " + m.getName());
      }
    }
  }

  public Book findBookByISBN(String isbn) throws InvalidBookException{
    /** Jika isbn null/kosong: throw InvalidBookException
      * Loop books array, bandingkan ISBN
      * Return book jika ditemukan, null jika tidak */
    if (isbn == null || isbn.trim().isEmpty()) throw new InvalidBookException("gaada ini");
  }
      

  public void displayAllBooks(){
    /* Jika bookCount == 0:
        - WAJIB PRINT EXACT: "Perpustakaan kosong."
      * Else:
        - WAJIB PRINT EXACT: "=== Daftar Buku di Perpustakaan ==="
        - Loop dan print setiap buku dengan format: "<nomor>. <book.toString()>"
        - Nomor mulai dari 1
        - Contoh output:
          === Daftar Buku di Perpustakaan ===
          1. Clean Code by Robert Martin (2008) [ISBN: 0-13-235088-2] - Available: 3/3
          2. Design Patterns by Gang of Four (1994) [ISBN: 978-0-201-63361-0] - Available: 2/2 */
    if (bookCount == 0){
      System.out.println("Perpustakaan kosong.");
    } else {
      System.out.println("=== Daftar Buku di Perpustakaan ===");
      for (int i = 0; i < bookCount; i++){
        System.out.printf("%d. %s\n", i+1, books[i].toString());
      }
    }
  }
   
  public void displayAllMembers(){
      /* Jika members.isEmpty():
        - WAJIB PRINT EXACT: "Tidak ada anggota terdaftar."
      * Else:
        - WAJIB PRINT EXACT: "=== Daftar Anggota Perpustakaan ==="
        - Loop members.values() dan print setiap member dengan format: "<nomor>. <member.toString()>"
        - Nomor mulai dari 1
        - Contoh output:
          === Daftar Anggota Perpustakaan ===
          1. Alice Johnson (ID: M001) - Borrowed: 2/3
          2. Bob Smith (ID: M002) - Borrowed: 0/5 */
	if (members.isEmpty()){
		System.out.println("Tidak ada anggota terdaftar.");
	} else {
		System.out.println("=== Daftar Anggota Perpustakaan ===");
		int i = 1;
		for (Member m : members.values()){
			System.out.printf("%d. %s\n", i, m.toString());
			i++;
		}
	}
  }

  public void displayMemberBooks(String memberId) throws LibraryException{
    /* member = findMember(memberId)
    * WAJIB PRINT EXACT: "=== Buku yang Dipinjam oleh " + member.getName() + " ==="
    * Jika getCurrentBorrowedCount() == 0:
    - WAJIB PRINT EXACT: "Tidak ada buku yang dipinjam."
    * Else:
    - Loop dan print setiap buku dengan format: "- <judul buku>"
    * Contoh output:
    === Buku yang Dipinjam oleh Alice Johnson ===
    - Clean Code
    - Design Patterns*/
	Member m = findMember(memberId);
	System.out.println("=== Buku yang Dipinjam oleh " + m.getName() + " ===");
	if (m.getCurrentBorrowedCount() == 0){
		System.out.println("Tidak ada buku yang dipinjam.");
	} else {
		for (String s : m.getBorrowedBooks()){
			System.out.println("- " + s);
		}
	}
  }

  public int getBookCount(){
	return bookCount;
  }

  public int getMemberCount(){
	return members.size();
  }
}