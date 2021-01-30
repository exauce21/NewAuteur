package sn.newauteur.edition;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("sn.newauteur.edition");

        noClasses()
            .that()
            .resideInAnyPackage("sn.newauteur.edition.service..")
            .or()
            .resideInAnyPackage("sn.newauteur.edition.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..sn.newauteur.edition.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
