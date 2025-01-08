public class Fraction{ 
    private int numerator; 
    private int denominator; 
    
    //creates the fraction object
    public Fraction(int num, int denom){ 
        numerator = num; 
        denominator = denom; 
    } 
    
    //getters and setters 
    public int getNumerator(){ 
        return numerator; 
    } 
    
    public void setNumerator(){ 
        numerator = numerator; 
    } 
    
    public int getDenominator(){ 
        return denominator; 
    } 
    
    public void setDenominator(){ 
        denominator = denominator; 
    } 
    
    //addition method
    public Fraction add(Fraction f){ 
        int finalNum = 0; 
        int finalDenom = 0; 
        if(this.denominator == f.denominator){ 
            finalNum = f.numerator + this.numerator; 
            finalDenom = this.denominator; 
        } 
        else if(this.denominator != f.denominator){
            //if the first fraction denominator is a multiple of the second fraction denominator
            //changes the second fraction to match the denominator of the first
            if(this.denominator % f.denominator == 0){ 
                int d = this.denominator / f.denominator; 
                finalNum = this.numerator + (f.numerator * d); 
                finalDenom = this.denominator; 
            }
            //if the second fraction denominator is a multiple of the first fraction denominator
            //changes the first fraction to match the denominator of the second
            else if(f.denominator % this.denominator == 0){ 
                int d = f.denominator / this.denominator; 
                finalNum = f.numerator + (this.numerator * d); 
                finalDenom = f.denominator; 
            }
            else{    
                finalNum = this.denominator * f.denominator; 
                finalDenom = (this.numerator * f.denominator) + (f.numerator * this.denominator); 
            }  
        } 
        return new Fraction(finalNum, finalDenom); 
    } 
    
    //subtraction method
    public Fraction subtract(Fraction f){ 
        int finalNum = 0; 
        int finalDenom = 0; 
        if(this.denominator == f.denominator){ 
            finalNum = this.numerator - f.numerator; 
            finalDenom = this.denominator; 
        } 
        else if(this.denominator != f.denominator){
            //if the first fraction denominator is a multiple of the second fraction denominator
            //changes the second fraction to match the denominator of the first
            if(this.denominator % f.denominator == 0){ 
                int d = this.denominator / f.denominator; 
                finalNum = this.numerator - (f.numerator * d); 
                finalDenom = this.denominator; 
            } 
            //if the second fraction denominator is a multiple of the first fraction denominator
            //changes the first fraction to match the denominator of the second
            else if(f.denominator % this.denominator == 0){ 
                int d = f.denominator / this.denominator; 
                finalNum = this.numerator - (f.numerator * d); 
                finalDenom = f.denominator; 
            }
            else{    
                finalNum = (this.numerator * f.denominator) - (f.numerator * this.denominator); 
                finalDenom = this.denominator * f.denominator;
            }  
        } 
        return new Fraction(finalNum, finalDenom); 
    } 
    
    //multiplication method
    public Fraction multiply(Fraction f){ 
        int finalNum = this.numerator * f.numerator; 
        int finalDenom = this.denominator * f.denominator;
        return new Fraction(finalNum, finalDenom); 
    } 
    
    //division method
    public Fraction divide(Fraction f){ 
        int finalNum = this.numerator * f.denominator; 
        int finalDenom = this.denominator * f.numerator;
        return new Fraction(finalNum, finalDenom); 
    }
    
    //simplify method
    //takes the highest number and uses it in a loop to find the highest common factor between the numerator and denominator
    public Fraction simplify(Fraction f){ 
        int highest = 0; 
        int divisor = 0; 
        numerator = f.numerator; 
        denominator = f.denominator; 
        if(f.numerator > f.denominator){ 
            highest = f.numerator; 
        } 
        else if(f.numerator < f.denominator){ 
            highest = f.denominator; 
        } 
        else{ 
            highest = f.numerator; 
        }
        for(int i = 1; i <= highest; i++){ 
            if(f.numerator % i == 0 && f.denominator % i == 0){ 
                divisor = i; 
                numerator = f.numerator / divisor; 
                denominator = f.denominator / divisor;
            } 
        } 
        return new Fraction(numerator, denominator); 
    }
    
    //arranges the object into the format of a fraction and simplifies it
    public String toString(){ 
        Fraction f = new Fraction(numerator, denominator); 
        f.simplify(f); 
        numerator = f.numerator; 
        denominator = f.denominator; 
        return numerator + "/" + denominator; 
    }
    
}
