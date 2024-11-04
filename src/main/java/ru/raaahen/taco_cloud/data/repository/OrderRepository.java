package ru.raaahen.taco_cloud.data.repository;

import org.springframework.data.repository.CrudRepository;

import ru.raaahen.taco_cloud.data.entity.TacoOrder;

public interface OrderRepository extends CrudRepository<TacoOrder, Long>
{
}
