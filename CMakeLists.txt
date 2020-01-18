cmake_minimum_required(VERSION 3.10)
project(generator)
set(CMAKE_CXX_STANDARD 17)

include_directories(${CMAKE_SOURCE_DIR}/include/antlr4-runtime)
link_directories(${CMAKE_SOURCE_DIR}/lib)

add_executable(generator
    src/main.cpp
    src/Terminal.cpp
    src/NonTerminal.cpp
    src/Grammar.cpp
    src/Base.cpp
    grammar/src/GrammarLexer.cpp
    grammar/src/GrammarParser.cpp
)

target_link_libraries(generator antlr4-runtime stdc++fs)

