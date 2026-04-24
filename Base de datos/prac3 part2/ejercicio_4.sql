set search_path = part2;

alter table vacunados
    add constraint fk_vacunados_vacunas
        foreign key (cod_vacuna)
        references vacunas (cod_vacuna)
        on delete cascade;



alter table vacunados
    add constraint fk_personas_vacunados
        foreign key (dni)
        references personas (dni)
        on delete restrict;

