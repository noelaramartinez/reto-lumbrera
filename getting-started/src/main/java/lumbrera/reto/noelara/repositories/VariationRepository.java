package lumbrera.reto.noelara.repositories;

import org.springframework.data.repository.CrudRepository;

import lumbrera.reto.noelara.models.Variations;

public interface VariationRepository extends CrudRepository<Variations, Long> {
    // this class extends all necesary methods for crud operations and the
    // capability to implement others
}
