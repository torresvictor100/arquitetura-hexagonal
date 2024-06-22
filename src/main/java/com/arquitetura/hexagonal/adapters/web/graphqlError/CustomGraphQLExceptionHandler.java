package com.arquitetura.hexagonal.adapters.web.graphqlError;

import com.arquitetura.hexagonal.application.domain.exception.*;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Component
public class CustomGraphQLExceptionHandler extends DataFetcherExceptionResolverAdapter {

    @Override
    protected List<GraphQLError> resolveToMultipleErrors(Throwable ex, DataFetchingEnvironment env) {

        if (ex instanceof ProductFailedToCreate) {
            return List.of(
                    GraphqlErrorBuilder.newError()
                            .message(ex.getMessage())
                            .errorType(ErrorType.INTERNAL_ERROR)
                            .path(env.getExecutionStepInfo().getPath())
                            .location(env.getField().getSourceLocation())
                            .build()
            );
        }

        if (ex instanceof ProductFailedToCreate) {
            return List.of(
                    GraphqlErrorBuilder.newError()
                            .message(ex.getMessage())
                            .errorType(ErrorType.INTERNAL_ERROR)
                            .path(env.getExecutionStepInfo().getPath())
                            .location(env.getField().getSourceLocation())
                            .build()
            );
        }

        if (ex instanceof ProductFailedToUpdate) {
            return List.of(
                    GraphqlErrorBuilder.newError()
                            .message(ex.getMessage())
                            .errorType(ErrorType.INTERNAL_ERROR)
                            .path(env.getExecutionStepInfo().getPath())
                            .location(env.getField().getSourceLocation())
                            .build()
            );
        }

        if (ex instanceof InvalidNameException) {
            return List.of(
                    GraphqlErrorBuilder.newError()
                            .message(ex.getMessage())
                            .errorType(ErrorType.BAD_REQUEST)
                            .path(env.getExecutionStepInfo().getPath())
                            .location(env.getField().getSourceLocation())
                            .build()
            );
        }

        if (ex instanceof InvalidIdException) {
            return List.of(
                    GraphqlErrorBuilder.newError()
                            .message(ex.getMessage())
                            .errorType(ErrorType.BAD_REQUEST)
                            .path(env.getExecutionStepInfo().getPath())
                            .location(env.getField().getSourceLocation())
                            .build()
            );
        }

        if (ex instanceof InvalidPriceException) {
            return List.of(
                    GraphqlErrorBuilder.newError()
                            .message(ex.getMessage())
                            .errorType(ErrorType.BAD_REQUEST)
                            .path(env.getExecutionStepInfo().getPath())
                            .location(env.getField().getSourceLocation())
                            .build()
            );
        }

        if (ex instanceof InvalidStatusException) {
            return List.of(
                    GraphqlErrorBuilder.newError()
                            .message(ex.getMessage())
                            .errorType(ErrorType.BAD_REQUEST)
                            .path(env.getExecutionStepInfo().getPath())
                            .location(env.getField().getSourceLocation())
                            .build()
            );
        }

        if (ex instanceof ProductNotFoundException) {
            return List.of(
                    GraphqlErrorBuilder.newError()
                            .message(ex.getMessage())
                            .errorType(ErrorType.NOT_FOUND)
                            .path(env.getExecutionStepInfo().getPath())
                            .location(env.getField().getSourceLocation())
                            .build()
            );
        }

        if (ex instanceof Exception) {
            return List.of(
                    GraphqlErrorBuilder.newError()
                            .message(ex.getMessage())
                            .errorType(ErrorType.INTERNAL_ERROR)
                            .path(env.getExecutionStepInfo().getPath())
                            .location(env.getField().getSourceLocation())
                            .build()
            );
        }
        return super.resolveToMultipleErrors(ex, env);
    }

    @Override
    protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
        if (ex instanceof ProductFailedToCreate) {
            return GraphqlErrorBuilder.newError()
                            .message(ex.getMessage())
                            .errorType(ErrorType.INTERNAL_ERROR)
                            .path(env.getExecutionStepInfo().getPath())
                            .location(env.getField().getSourceLocation())
                            .build();

        }

        if (ex instanceof ProductFailedToCreate) {
            return GraphqlErrorBuilder.newError()
                            .message(ex.getMessage())
                            .errorType(ErrorType.INTERNAL_ERROR)
                            .path(env.getExecutionStepInfo().getPath())
                            .location(env.getField().getSourceLocation())
                            .build();

        }

        if (ex instanceof ProductFailedToUpdate) {
            return GraphqlErrorBuilder.newError()
                            .message(ex.getMessage())
                            .errorType(ErrorType.INTERNAL_ERROR)
                            .path(env.getExecutionStepInfo().getPath())
                            .location(env.getField().getSourceLocation())
                            .build();
        }

        if (ex instanceof InvalidNameException) {
            return GraphqlErrorBuilder.newError()
                            .message(ex.getMessage())
                            .errorType(ErrorType.BAD_REQUEST)
                            .path(env.getExecutionStepInfo().getPath())
                            .location(env.getField().getSourceLocation())
                            .build();
        }

        if (ex instanceof InvalidIdException) {
            return GraphqlErrorBuilder.newError()
                            .message(ex.getMessage())
                            .errorType(ErrorType.BAD_REQUEST)
                            .path(env.getExecutionStepInfo().getPath())
                            .location(env.getField().getSourceLocation())
                            .build();
        }

        if (ex instanceof InvalidPriceException) {
            return GraphqlErrorBuilder.newError()
                            .message(ex.getMessage())
                            .errorType(ErrorType.BAD_REQUEST)
                            .path(env.getExecutionStepInfo().getPath())
                            .location(env.getField().getSourceLocation())
                            .build();
        }

        if (ex instanceof InvalidStatusException) {
            return GraphqlErrorBuilder.newError()
                            .message(ex.getMessage())
                            .errorType(ErrorType.BAD_REQUEST)
                            .path(env.getExecutionStepInfo().getPath())
                            .location(env.getField().getSourceLocation())
                            .build();
        }

        if (ex instanceof ProductNotFoundException) {
            return GraphqlErrorBuilder.newError()
                            .message(ex.getMessage())
                            .errorType(ErrorType.NOT_FOUND)
                            .path(env.getExecutionStepInfo().getPath())
                            .location(env.getField().getSourceLocation())
                            .build();
        }

        if (ex instanceof Exception) {
            return GraphqlErrorBuilder.newError()
                            .message(ex.getMessage())
                            .errorType(ErrorType.INTERNAL_ERROR)
                            .path(env.getExecutionStepInfo().getPath())
                            .location(env.getField().getSourceLocation())
                            .build();
        }
        return super.resolveToSingleError(ex, env);
    }
}
