package com.nelioalves.cursomc.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.domain.Produto;

//É uma interface que herda de JpaRepository acessando os dados do tipo Categoria com o atributo identificador Integer (do id)
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
	
//	@Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat WHERE obj.nome LIKE %:nome% AND cat IN :categorias")
//	Page<Produto>search(@Param ("nome") String nome, @Param ("categorias") List<Categoria> categorias, Pageable pageRequest);
	
	
	
	//Usando todo o poder do Spring com o nome do método (Observar item 4.3 do Reference do Spring Data
	@Transactional (readOnly = true)
	Page<Produto> findDistinctByNomeContainingAndCategoriasIn (String nome, List<Categoria> categorias, Pageable pageRequest);

}
