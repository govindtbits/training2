package com.tbitsglobal;

import org.datanucleus.query.typesafe.*;
import org.datanucleus.api.jdo.query.*;

public class QEmployee extends org.datanucleus.api.jdo.query.PersistableExpressionImpl<Employee> implements PersistableExpression<Employee>
{
    public static final QEmployee jdoCandidate = candidate("this");

    public static QEmployee candidate(String name)
    {
        return new QEmployee(null, name, 5);
    }

    public static QEmployee candidate()
    {
        return jdoCandidate;
    }

    public static QEmployee parameter(String name)
    {
        return new QEmployee(Employee.class, name, ExpressionType.PARAMETER);
    }

    public static QEmployee variable(String name)
    {
        return new QEmployee(Employee.class, name, ExpressionType.VARIABLE);
    }

    public final NumericExpression<Long> serialVersionUID;
    public final NumericExpression<Integer> employeeId;
    public final StringExpression address;
    public final StringExpression mob;

    public QEmployee(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        this.serialVersionUID = new NumericExpressionImpl<Long>(this, "serialVersionUID");
        this.employeeId = new NumericExpressionImpl<Integer>(this, "employeeId");
        this.address = new StringExpressionImpl(this, "address");
        this.mob = new StringExpressionImpl(this, "mob");
    }

    public QEmployee(Class type, String name, org.datanucleus.api.jdo.query.ExpressionType exprType)
    {
        super(type, name, exprType);
        this.serialVersionUID = new NumericExpressionImpl<Long>(this, "serialVersionUID");
        this.employeeId = new NumericExpressionImpl<Integer>(this, "employeeId");
        this.address = new StringExpressionImpl(this, "address");
        this.mob = new StringExpressionImpl(this, "mob");
    }
}
