package com.personal.designpatterns.infrastructure.bus

import org.springframework.beans.factory.InitializingBean
import org.springframework.stereotype.Service
import java.util.function.Consumer

interface Request

interface RequestHandler<R : Request, T> {
    suspend fun handle(request: R): T
    fun getRequestType(): Class<R>
}


@Service
class Bus(
    private val requestHandlers: List<RequestHandler<out Request, *>>,
) : InitializingBean {
    private val map: MutableMap<Class<out Request>, RequestHandler<out Request, *>> = HashMap()

    suspend fun <R : Request, T> execute(request: R): T {

        return (map[request.javaClass] as RequestHandler<R, T>).handle(request)
    }

    override fun afterPropertiesSet() {
        requestHandlers.forEach(Consumer { requestHandler: RequestHandler<out Request, *> ->
            map[requestHandler.getRequestType()] = requestHandler
        }) //TODO
    }
}