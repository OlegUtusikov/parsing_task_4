all : clean test

build:
	cd grammar && mkdir src && antlr4 -Dlanguage=Cpp -o ./src ./Grammar.g4
	mkdir build && cd build && cmake ./../
	cd build && make
	cd src && cp Tools.hpp ./../test
	cd src && cp Tools.hpp ./../build
	cd src && cp Tools.hpp ./../task

run: build
	cp example.txt build
	cd build && ./generator example.txt
	cd build && cp lexer.hpp ./../test
	cd build && cp lexer.cpp ./../test
	cd build && cp parser.hpp ./../test
	cd build && cp parser.cpp ./../test

test: run
	cd test && make
	cd test && ./main

tasks: clean build
	cd task && cp grammarVar.txt ./../build
	cd build && ./generator grammarVar.txt
	cd build && cp lexer.hpp ./../task
	cd build && cp lexer.cpp ./../task
	cd build && cp parser.hpp ./../task
	cd build && cp parser.cpp ./../task
	cd task && make
	cd task && ./main 'var a,b:integer; q:real; ttr:boolean; fff: integer; rtrt: char;' no-print
	cd task && ./main 'var q, 	  t, r, a, 		w, q : 	 real;' no-print
	cd task && ./main 'var a,b:integer' no-print
	cd task && ./main 'var a,b: int;' no-print
	cd task && ./main 'var a b:integer; q:real; ttr:boolean;qeq:integer;charc: char;' no-print
	cd task && ./main 'var a,b:integer; q:real; ttr:boolean; yte: integer; jhf: char;' print

clean:
	rm -rf ./grammar/src
	rm -rf ./build