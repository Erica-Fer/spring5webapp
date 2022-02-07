package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author ono = new Author("Ono", "Fuyumi");
        Book twlvKing = new Book("The Twelve Kingdoms", "123123");
        ono.getBooks().add(twlvKing);
        twlvKing.getAuthors().add(ono);

        authorRepository.save(ono);
        bookRepository.save(twlvKing);

        Author ursula = new Author("Ursula", "K. LeGuin");
        Book earthsea = new Book("Wizard of Earthsea", "234234");

        ursula.getBooks().add(earthsea);
        earthsea.getAuthors().add(ursula);

        authorRepository.save(ursula);
        bookRepository.save(twlvKing);

        System.out.println("Started in Bootstrap!");
        System.out.println("Number of books: " + bookRepository.count());
    }
}
