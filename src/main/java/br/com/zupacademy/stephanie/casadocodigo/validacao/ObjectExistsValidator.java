package br.com.zupacademy.stephanie.casadocodigo.validacao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ObjectExistsValidator implements ConstraintValidator<ObjectExists, Object> {

    private String field;
    private Class<?> entity;

    private EntityManager em;

    public ObjectExistsValidator(EntityManager em) {
        this.em = em;
    }

    @Override
    public void initialize(ObjectExists constraintAnnotation) {
        this.field = constraintAnnotation.field();
        this.entity = constraintAnnotation.entity();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        String jpql = "SELECT c FROM " +entity.getName()+ " c WHERE " +field+ "= :pValue";
        Query query = em.createQuery(jpql);
        query.setParameter("pValue", value);
        List<?> resultList = query.getResultList();

        return !resultList.isEmpty();
    }

}
