package hwjava07_부울경_04반_차상훈;

public class ISBNNotFoundException extends RuntimeException {
	public ISBNNotFoundException() {
	}
	public ISBNNotFoundException(String isbn) {
		super(String.format("isbn %s번에 해당하는 책이 등록되지 않았습니다.", isbn));
	}
}
