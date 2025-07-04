import java.util.*;

class Solver {
    public static void main (String[] args) {
        Biblioteca bib = new Biblioteca( 1 );

        while (true) {
            String[] line = IO.inputPartsPrintingLine();

            if      ( line[0].equals("end")        )  { break;                                                            }
            else if ( line[0].equals("show")       )  { IO.println( bib );                                                }
            else if ( line[0].equals("init")       )  { bib = new Biblioteca( IO.strToInt(line[1]) );                     }
            else if ( line[0].equals("livro")       )  { 
                    String titulo = "";
                    for (int i = 1; i < line.length - 1; i++) {
                        titulo += line[i];
                        
                        if(i < line.length - 2) {
                            titulo += " ";
                        }
                    } 
                    int ano = IO.strToInt(line[line.length -1]);
                    bib.adicionarLivro(new Livro(titulo, ano));                                                         } 
            else if ( line[0].equals("leitor")     )  { bib.registrarLeitor( new Leitor( line[1] ) );                     }
            else if ( line[0].equals("emprestar")  )  { bib.emprestarLivro( IO.strToInt(line[1]) );                       }
            else if ( line[0].equals("receber")    )  { bib.receberLivro();                                               }
            else                                      { IO.println("fail: comando invalido");                             }
        }
    }
}
