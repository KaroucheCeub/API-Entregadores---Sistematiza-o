package dianome.entregas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import dianome.entregas.modelos.EntregasModelos;

@Repository

public interface Repositorio extends JpaRepository<EntregasModelos,Integer>{


}
