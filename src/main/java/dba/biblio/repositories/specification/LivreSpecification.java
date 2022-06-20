package dba.biblio.repositories.specification;
import dba.biblio.entities.Livre;
import org.springframework.data.jpa.domain.Specification;

public class LivreSpecification {

    public static Specification<Livre> findBy(String property, String value) {
        return (root, query, criteriaBuilder) -> {
            if (value == null || value.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.like(root.<String>get(property), value);
        };
    }

    public static Specification<Livre> findBy(String property, String attribute, String value) {
        return (root, query, criteriaBuilder) -> {
            if (value == null || value.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.like(root.<String>get(property).get(attribute), value);
        };
    }
}
