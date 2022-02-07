package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository
            , BookRepository bookRepository
            , PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher penguin = new Publisher("Penguin Books", "1234 Related ST", "Seattle", "WA", 98001);

        publisherRepository.save(penguin);

        Author ono = new Author("Ono", "Fuyumi");
        Book twlvKing = new Book("The Twelve Kingdoms", "123123");
        ono.getBooks().add(twlvKing);
        twlvKing.getAuthors().add(ono);

        twlvKing.setPublisher(penguin);
        penguin.getBooks().add(twlvKing);

        authorRepository.save(ono);
        bookRepository.save(twlvKing);

        Author ursula = new Author("Ursula", "K. LeGuin");
        Book earthsea = new Book("Wizard of Earthsea", "234234");

        ursula.getBooks().add(earthsea);
        earthsea.getAuthors().add(ursula);

        earthsea.setPublisher(penguin);
        penguin.getBooks().add(earthsea);

        authorRepository.save(ursula);
        bookRepository.save(earthsea);
        publisherRepository.save(penguin);

        System.out.println("Started in Bootstrap!");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of publishers: " + penguin.getBooks().size());
    }
}
