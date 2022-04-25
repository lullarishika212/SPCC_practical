%{
// Definitions
%}

%%
[a-zA-Z]+ {
	printf("\nEntered charater is an alphabet. ");
	ECHO;
} 
[0-9]+ {
	printf("\nEntered charater is an integer.  ");
	ECHO;
}
. {
	printf("\nEntered charater is a special symbol.  ");
	ECHO;
}
%%

int yywrap(){return(1);}
int main()
{
	printf("Enter a character: ");
	yylex();
	return 0;
}