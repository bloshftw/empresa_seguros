-- Agrego una nueva columna para extender descripcion de cada propiedad
-- Autor: Luciano Jesus Rodriguez
-- Fecha del posible cambio: 12/07/2025

ALTER TABLE propiedades ADD detalle_propiedad VARCHAR(255) DEFAULT NULL;