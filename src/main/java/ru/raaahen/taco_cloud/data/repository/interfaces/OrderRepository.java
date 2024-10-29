package ru.raaahen.taco_cloud.data.repository.interfaces;

import ru.raaahen.taco_cloud.data.entity.TacoOrder;

public interface OrderRepository 
{
    TacoOrder save(TacoOrder order);
}
