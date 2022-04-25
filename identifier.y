%{
#include<stdio.h>
#include<stdlib.h>
int yylex();
void yyerror(char *s);
%}
%token DIGIT LETTER NL UND
%%
stmt: variable NL { printf("Valid identifiers\n"); exit(0); };
variable: LETTER alphanumeric;
alphanumeric: LETTER alphanumeric |
DIGIT alphanumeric |
UND alphanumeric |
LETTER |
DIGIT |
UND;
%%

#include<stdio.h>
#include<stdlib.h>
void yyerror(char *msg)
{
printf("Invalid expression : %s \n", msg);
}
int main()
{
printf("Enter a variable name.\n");
yyparse();
}
