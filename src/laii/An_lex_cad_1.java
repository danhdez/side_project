package laii;

import java.io.IOException;
import java.util.ArrayList;


public class An_lex_cad_1 {
    //VARIABLES
    ArrayList tokens=new ArrayList();
    ArrayList ar[]=new ArrayList[2]; //GUARDA LOS TOKENS QUE LA CADENA ORIGINAL
    private String lastt=""; //GUARDA EL ULTIMO TOKEN GENERADO
    private boolean b[]=new boolean[9];//Revisa las etiquetas
    private ArrayList listatokens[]=new ArrayList[3];
    
    
    
    An_lex_cad_1(){
        ar[0]=new ArrayList();
        ar[1]=new ArrayList();
    }
    public ArrayList getTokens() {
        return tokens;
    }
    private void primertoken (String c){
        char aux[];
        aux=c.toCharArray();
        String token="";
        for (int i = 0; i < aux.length; i++){
            if (aux[i] != '|') {
                token+=aux[i];
            }else{
                ar[0].add(token);
                token="";
            }
        }
        if (token!= "") {
            ar[0].add(token);            
        }
        
    }
    
    void queEs(char c) throws IOException{
        int  com=0;
        int comd=0; 
        if (Character.isLetter(c)) {
            lastt+=c;
        }else{
            switch (c) {
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                    case '0':
                        lastt+=c;
                        
                              break;
                case '>':
                     if (lastt!=""&&b[0]==false) {
                        buscar(lastt);
                        lastt="";
                    }
                    if (!b[0]&&b[5]) { //SI no era antes ya una etiqueta y se encontro la palabra reservada
                        b[0]=true; //se vuelve etiqueta
                        
                        b[5]=false;//deja de ser palabra reservada
                    }else{
                        b[4]=true; //De lo contrario es admitido unicamente como texto plano
                    }
                    break;

                case '<':
                    if (lastt=="") {
                        b[1]=true; //Es etiqueta que cierra
                    }
                    break;
                    
                case '(':               //Al encontrarse un parentesis  se verifica que lo que este antes sea una palabra en la tabla de tokens
                    buscar(lastt);
                        if(b[5]){
                        b[7]=true;}                   //De ser así se valida como funcion en primera instancia
                        else b[4]=true;             //Si no es texto plano
                    break;        
                                        
                 
                case '"':               //Si se encuentra una comilla doble se aumenta un contador, se procesa despues al encontrar un pipe
                    comd=comd+1;
                    break;
                 case '\'':              //Si se encuentra una comilla se aumenta un contador, se procesa despues
                    com=com+1;
                    break;
                case '@':
                    
                    b[2]=true;
                    
                    break;
                    
                case '|':
                    
                    if(lastt.length()==1){    //Si sólo contiene un caracter rodeado de espacios se acepta como caracter especial
                    char tmp []=lastt.toCharArray();
                        if(((tmp[0]>='\'')&&(tmp[0])<='.')||((tmp[0]>=':')&&(tmp[0])<='@')){
                            for(int a=0; a<b.length;a++){
                                        b[a]=false;
                                               }
                            b[6]=true;
                            
                        }
                    }
                    
                    
                    if(lastt.matches(".*\\d.*")){
                            Constante con=new Constante();
                            con.Dividir(lastt);
                             for(int a=0; a<b.length;a++){
                                        b[a]=false;
                                               }
                            b[3]=con.isBandera();
                            b[4]=!b[3];
                    }
                    
                    if (lastt!="") {
                        buscar(lastt);
                        if (b[5]==false) {
                                for(int a=0; a<b.length;a++){
                                        b[a]=false;
                                               }
                            b[4]=true;
                        }
                    }
                    
                    
                    if (lastt!=""&&b[2]) {
                        Variable var=new Variable();
                        var.Dividir(lastt);
                        for(int a=0; a<b.length;a++){
                                        b[a]=false;
                                               }
                            b[2]=var.isBandera();
                            b[4]=!b[2];
                        
                   }
                    
                    
                    
                    if(lastt=="\""){
                            if(comd%2==0){
                                b[4]=true;
                                comd=0;
                            }
                    }
                    
                    if(lastt=="'"){
                            if(com%2==0){
                                b[4]=true;
                                com=0;
                            }
                    }
                    
                    if (lastt==")"&&b[7]){
                            for(int a=0; a<b.length;a++){
                                    b[a]=false;
                               }
                                    b[7]=true;
                    }
                    
//                    if (lastt=="@"){
//                    for(int a=0; a<b.length;a++){
//                    b[a]=false;
//                    }
//                    b[4]=true;
//                    }
                    
//                    if(lastt=="<"){
//                     for(int a=0; a<b.length;a++){
//                    b[a]=false;
//                    }
//                            b[4]=true;
//                    }
//                    
                    
                    
                    
                    for (int i = 0; i < 7; i++) {
                        if (b[i]==true) {
                            ar[1].add(i);
                        }
                    }   
                
                    for (int i = 0; i < 7; i++) {
                        if (b[i]) {
                            ar[1].add(b[i]);
                        }
                    }
                    
                            break;
                default:
                    for(int a=0; a<b.length;a++){
                    b[a]=false;
                    }
                    b[4]=true;
            }
        }
    }
    
    void buscar(String c){
        tokens_1 tk=new tokens_1();
        tk.buscar(c);
        if (tk.isBan()) {
            b[5]=tk.isBan();
            listatokens[0].add(c);
            listatokens[1].add(tk.getGroup());
            listatokens[2].add(tk.getCod());
        }else{
            System.out.println("EN EL METODO DE BUSCAR, NO SE ENCONTRO EL TOKEN");
        }
    }
    void Identificar() throws IOException{ //Pide el arreglo de tokens primarios
            String aux="",token="",grupo="",codigo="";
            char c[];
            boolean st=true,va=true,co=true,te=true;

            for (int i = 0; i < 7; i++) {
                        b[i]=false;
            }

            for (int i = 0; i < ar[0].size(); i++) {//RECORRE EL ARREGLO
                    aux=ar[0].get(i)+"";//CONSIGO ELEMENTO DEL ARREGLO
                    c=aux.toCharArray();//DIVIDO EL ELEMENTO CONSEGUIDO

                    for (int j = 0; j < c.length; j++) { //TRABAJA SOBRE EL ELEMENTO CONSEGUIDO Y GUARDADO EN UN ARREGLO DE CARACTERES
                        if ((c[j]>='a'&&c[j]<='z')||(c[j]>='A'&&c[j]<='Z')||(c[j]>=' '&&c[j]<='@')||(c[j]=='[')||(c[j]==']')) {
                            queEs(c[j]);
                        }

                        //REVISA CUANDO ENCUENTRA UN NUMERO  
                            if(c[j]>='0'&&c[j]<='9'){
                                token+=c[j];
                            }else{
                                Constante con =new Constante();
                                con.Dividir(token);
                                co=con.isBandera();
                                int cod =0;
                                System.out.println("Num");
                            if (co==true) {
                                System.out.println("Num true");
                               cod=98;
                            }
                }
                if(token.contains("@")){
                Variable var = new Variable();
                var.Dividir(token);
                va=var.isBandera();
                int cod=0;
                    System.out.println("var");
                if(va){
                    System.out.println("var true");
                cod=99;
                }

                }
                else{
                    System.out.println("txt");
                int cod=97;
                }
                        }


            }

        }

//    void cargar(String cadena) throws IOException{
//        char aux[];
//        
//        String token="";
//        ArrayList car;
//        
//        car=ar[0];
//        for (int k = 0; k < car.size(); k++) {
//            aux=car.get(k).toString().toCharArray();
//            
//        
//        for (int i = 0; i < aux.length; i++) {
//            if ((aux[i]>='a'&&aux[i]<='z')||(aux[i]>='A'&&aux[i]<='Z')||(aux[i]>='0'&&aux[i]<='9')) {
////                System.out.println("Entra");
////                System.out.println(""+aux.length);
//                token+=aux[i];
//            }else{
//                if (token!="") {
//                    tokens.add(token);
//                    token="";
//                }
//                switch (aux[i]) {
//                    case '>':
//                        tokens.add('>');
//                        break;
//                    case '<':
//                        tokens.add('<');
//                        break;
//                    case ';':
//                        tokens.add(';');
//                        break;
//                   case '@':
//                       Variable var=new Variable();
//                       int j=1;
//                       token+=aux[i];
//                       boolean algo=false;
//                       while(Character.isLetterOrDigit(aux[i+j])==true) {
//                           token+=aux[i+j];
//                           j++;
//                           algo=true;
//                       }
//                       
//                       if (algo) {
//                           var.Verifica(token);
//                           tokens.add(token);
//                       }
//                       
//
//                        break;
//               
//                    default:
////                        throw new AssertionError();
//                        
//                }
//            }
//        }
//        
//        if (token!="") {
//            tokens.add(token);
//        }
//        }
//    }
      
    public static void main(String[] args) throws IOException {
        
        An_lex_cad_1 m=new An_lex_cad_1();
        m.primertoken("html>\n" +
                "algo>\n" +
                "<nada\n" +
                "<html");
        m.Identificar();
        
        
        for (int i = 0; i < m.ar[0].size(); i++) {
            System.out.println("valor-->" + m.ar[0].get(i) + " " + m.ar[1].get(i)    );
        }
        for (int i = 0; i < m.tokens.size(); i++) {
            System.out.println("---------\n"+m.tokens.get(i));
        }
    }
    
}