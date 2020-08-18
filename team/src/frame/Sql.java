package frame;

public class Sql {
	
	public static String productInsert = "INSERT INTO PRODUCT VALUES (?,?,?,?)";
	public static String productUpdate = "UPDATE PRODUCT SET CATEGORY_ID=?, NAME=?, PRICE=? WHERE ID=?";
	public static String productDelete = "DELETE FROM PRODUCT WHERE ID=?";
	public static String productSelect = "SELECT * FROM PRODUCT WHERE ID=?";
	public static String productSelectAll = "SELECT * FROM PRODUCT ORDER BY CATEGORY_ID,ID ASC";

	
	// 결제하기 버튼 클릭 start //
	// 1. CUSTOMER 테이블 insert: ? = PAYMENT
	public static String customerInsert = "INSERT INTO CUSTOMER VALUES (CUSTOMER_SEQ.NEXTVAL,?)";
	
	// CUSTOMER 현재 ID를 반환한다.
	public static String customerCurrSeq = "SELECT CUSTOMER_SEQ.CURRVAL FROM DUAL";
	
	// 2. RECEIPT 테이블 insert: ? = (CUSTOMER_ID, CUSTOMER_ID, STORE_ID, TOTAL)
	public static String receiptInsert = "INSERT INTO RECEIPT VALUES (TO_CHAR(SYSDATE, 'YYYYMMDD')||?,?,?,SYSDATE,?)";
	
	// 2-0. RECEIPT 테이블 select: ? = (RECEIPT_ID)
	public static String receiptSelect = "SELECT * FROM RECEIPT WHERE ID=?";
	
	// 3 SALES 테이블 insert: ? = (RECEIPT_ID, STOCK_ID, NUM, TOTAL_PRICE)
	public static String salesInsert = "INSERT INTO SALES VALUES (TO_CHAR(SYSDATE, 'YYMMDDHH24MI'),?,?,?,?)";
	
	// 4. STOCK 테이블 update: ? = (NUM, PRODUCT_ID, STORE_ID)
	// QT에서 구매수랑 NUM을 뺀다.
	public static String stockUpdate = "UPDATE STOCK SET QT=QT-? WHERE PRODUCT_ID=? AND STORE_ID=?";
	
	

	// 결제하기 버튼 클릭 end //
		
	
}








