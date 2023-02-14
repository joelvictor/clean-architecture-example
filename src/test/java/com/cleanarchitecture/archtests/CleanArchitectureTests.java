package com.cleanarchitecture.archtests;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.Architectures;

@AnalyzeClasses(packages = "com.cleanarchitecture",
        importOptions = {
                ImportOption.DoNotIncludeTests.class,
                ImportOption.DoNotIncludeJars.class
        })
public class CleanArchitectureTests {

    @ArchTest
    static ArchRule layers_should_respect_clean_architecture_pattern =
            Architectures.layeredArchitecture()
                    .consideringAllDependencies()
                    .layer("api").definedBy("..api..")
                    .layer("application").definedBy("..application..")
                    .layer("domain").definedBy("..domain..")
                    .layer("infrastructure").definedBy("..infrastructure..")

                    .whereLayer("api").mayNotBeAccessedByAnyLayer()
                    .whereLayer("infrastructure").mayOnlyBeAccessedByLayers("api")
                    .whereLayer("application").mayOnlyBeAccessedByLayers("api", "infrastructure")
                    .whereLayer("application").mayOnlyBeAccessedByLayers("api");
}
