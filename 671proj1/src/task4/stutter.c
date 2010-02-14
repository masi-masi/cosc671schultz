#include <stdio.h>

main (argc, argv)
int argc;
char *argv [];
{
FILE *fp, *fopen ();

if (argc == 1)
		Stut (stdin);
	else
	while (--argc > 0)
		if ((fp = fopen (*++argv, "r")) == NULL) {
			printf ("stutter: can't open %s\n", *argv);
			break;
		}
		else {
			Stut (fp);
			fclose (fp);
		}
}

Stut (x)
FILE *x;
{
	char c, cu [100], l [100];
	int i = 0; ; int lc = 1;
	int ld = 1;
	
	l[0] = '\0';
	while((c = getc(x)) !=EOF) {
		if(c == '\n')
			lc++;
		if(del (c)) {
			if(ld)
				continue;
			ld = 1;
			cu [i] = '\0';
			i = 0;
			if(same(l, cu)) {
			printf("Repeated word on line %d; %s %s\n", lc, l, cu); }
			else 
				cp(cu, l);
		} else {
			ld = 0;
			cu [i++] = c;
		}
	}
	putc ('\n', stdout);
}

int del (C)
char C;
{
	static char dels [] = {'\0', '\n', '	', ' ', ',', '.', '!', '-', '+', '=', ';', ':', '?', '&', '{', '}', '\\'};
	int N = 17;
	int i;
	
	for (i = 0; i <= N-1; i++)
		if(C == dels [i])
			return (1);
	return (0);
}

int same (a, b)
char *a, *b;
{
	int i = 0;
	while((a[i] != '\0') && (b[i] != '\0')) {
		if(a [i] != b[i])
			return (0);
		i++;
	}
	if((a[i] == '\0') && (b[i] == '\0'))
		return (1);
	else
		return (0);
}

cp (a, b)
char *a, *b; 
{
	int i = 0;

	do 
		b[i] = a[i];
	while(a[i++] != '\0');
}
