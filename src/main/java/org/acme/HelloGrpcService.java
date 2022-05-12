package org.acme;

import io.quarkus.grpc.GrpcService;

import io.quarkus.logging.Log;
import io.smallrye.mutiny.Uni;
import javax.inject.Inject;
import org.acme.repository.jooq.Tables;
import org.acme.repository.jooq.tables.pojos.DeviceEntity;
import org.jooq.DSLContext;

@GrpcService
public class HelloGrpcService implements HelloGrpc {

    @Inject
    DSLContext dsl;

    @Override
    public Uni<HelloReply> sayHello(HelloRequest request) {
        DeviceEntity entity =
            dsl.selectFrom(Tables.DEVICE).where(Tables.DEVICE.NAME.eq(request.getName()))
                .fetchOneInto(DeviceEntity.class);

        Log.infof("Entity %s", entity);
        return Uni.createFrom().item("Hello " + request.getName() + "!")
                .map(msg -> HelloReply.newBuilder().setMessage(msg).build());
    }

}
