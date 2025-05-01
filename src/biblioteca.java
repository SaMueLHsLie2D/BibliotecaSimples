import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();

    public void adicionarLivro(String titulo, String autor, String isbn) {
        livros.add(new Livro(titulo, autor, isbn));
    }

    public List<Livro> listarLivros() {
        return new ArrayList<>(livros);
    }

    /**
     * Buscar livros por autor, ignorando maiúsculas/minúsculas.
     *
     * @param autor Nome do autor a ser buscado.
     * @return Lista de livros do autor especificado.
     */
    public List<Livro> buscarPorAutor(String autor) {
        return livros.stream()
                .filter(livro -> livro.getAutor().equalsIgnoreCase(autor.trim()))
                .collect(Collectors.toList());
    }

    /**
     * Buscar um livro pelo ISBN.
     *
     * @param isbn ISBN do livro.
     * @return Livro correspondente ou null se não encontrado.
     */
    public Livro buscarPorIsbn(String isbn) {
        return livros.stream()
                .filter(livro -> livro.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
    }
}

