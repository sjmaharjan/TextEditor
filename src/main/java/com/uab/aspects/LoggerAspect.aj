package com.uab.aspects;

import com.uab.model.Composition;

public aspect LoggerAspect {

	pointcut componentsChange(Composition composition) :
	    (call(* add(..)) || call(* remove(..))) 
	    && target(composition);

	after(Composition composition) : componentsChange(composition) {
		System.out.println(" [AspectJ logging:: Method Called: "+thisJoinPoint.getSignature().getName()+" ]: This components are "
				+ composition.getComponents());
	}
}
