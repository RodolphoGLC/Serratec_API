package com.residencia.gerenciamentoVendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.residencia.gerenciamentoVendas.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
