package sn.newauteur.edition.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.newauteur.edition.domain.Authority;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {}
