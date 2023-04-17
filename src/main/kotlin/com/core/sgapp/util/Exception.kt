package com.core.sgapp.util


open class UserException(val errorCode: ErrorCode, message: String?) : RuntimeException(message)

class UserNotFoundException : UserException {
    constructor() : super(ErrorCode.USER_NOT_FOUND, "User not found")
    constructor(message: String?) : super(ErrorCode.USER_NOT_FOUND, message)
}

class UserConflictException : UserException {
    constructor() : super(ErrorCode.USER_CONFLICT, "User conflict")
    constructor(message: String?) : super(ErrorCode.USER_CONFLICT, message)
}

class  EntityNotFoundException : UserException {
    constructor() : super(ErrorCode.ENTITY_NOT_FOUND, "Entity not found")
    constructor(message: String?) : super(ErrorCode.ENTITY_NOT_FOUND, message)
}
