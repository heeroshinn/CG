//
//  cgShape.java
//
//  Class that includes routines for tessellating a number of basic shapes.
//
//  Students are to supply their implementations for the functions in
//  this file using the function "addTriangle()" to do the tessellation.
//

import java.util.Vector;

public class cgShape extends simpleShape
{
    /**
	 * constructor
	 */
	public cgShape()
	{
	}
    
    public class points{ 
        float x,y,z;
        
        public points(float x1, float y1, float z1){
            setx(x1);
            sety(y1);
            setz(z1);
        }
        public points() {
			
		}
		
        public void copy(points a, points b) {
            a.x = b.x;
            a.y = b.y;
            a.z = b.z;
        }
        
        public void setx(float x1) {
            
            x=x1;
        }
        
        public float getx() {
            
            return x;
        }
        
        public void sety(float y1) {
            
			y=y1;	
        }
        
        public float gety() {
            
			return y;	
        }
        
        public void setz(float z1) {
            
			z=z1;
        }
        
        public float getz() {
            
			return z;	
        }
        
    }
    
    
    void frontback(points a, points b, points c, points d, int subdivisions){
    	
    	int sd=subdivisions;
    	
		if( subdivisions == 1){	
            addTriangle(a.getx(),a.gety(),a.getz(),b.getx(),b.gety(),b.getz(),c.getx(),c.gety(),c.getz() );	
            addTriangle(c.getx(),c.gety(),c.getz(),b.getx(),b.gety(),b.getz(),d.getx(),d.gety(),d.getz());
            a.setz(-a.getz());b.setz(-b.getz());c.setz(-c.getz());d.setz(-d.getz());
            
            addTriangle(a.getx(),a.gety(),a.getz(),c.getx(),c.gety(),c.getz() ,b.getx(),b.gety(),b.getz());	
            addTriangle(c.getx(),c.gety(),c.getz(),d.getx(),d.gety(),d.getz(),b.getx(),b.gety(),b.getz());
        }
        else{
            for(int i = 1;i <= sd; i++){
                float step= 1.0f/sd;
                b.sety( (a.gety()) - (step));	
                for(int j = 1; j <= sd; j++){
                    
                    c.setx(a.getx() + (step));
                    addTriangle(a.getx(),a.gety(),a.getz(),b.getx(),b.gety(),b.getz(),c.getx(),c.gety(),c.getz() );	
                    a.setz(-1*a.getz()); b.setz(-1*b.getz());c.setz(-1*c.getz());d.setz(-1*d.getz());
                    addTriangle(a.getx(),a.gety(),a.getz(),c.getx(),c.gety(),c.getz() ,b.getx(),b.gety(),b.getz() );
                    a.setz(-1*a.getz()); b.setz(-1*b.getz());c.setz(-1*c.getz());d.setz(-1*d.getz());d.setx( c.getx());d.sety( b.gety());
                    addTriangle(c.getx(),c.gety(),c.getz(),b.getx(),b.gety(),b.getz(),d.getx(),d.gety(),d.getz());
                    a.setz(-1*a.getz()); b.setz(-1*b.getz());c.setz(-1*c.getz());d.setz(-1*d.getz());
                    addTriangle(c.getx(),c.gety(),c.getz(),d.getx(),d.gety(),d.getz(),b.getx(),b.gety(),b.getz());
                    a.setz(-1*a.getz()); b.setz(-1*b.getz());c.setz(-1*c.getz());d.setz(-1*d.getz());
                    
                    a.setx(c.getx()); a.sety(c.gety());a.setz(c.getz());							
                    b.setx(d.getx());b.sety(d.gety());b.setz(d.getz());
                }
    			
                a.setx(-0.5f); a.sety(0.5f);  a.setz(0.5f);		
                b.setx(-0.5f); b.sety(-0.5f);  b.setz(0.5f);	
                c.setx(0.5f); c.sety(0.5f);  c.setz(0.5f);	
                d.setx(0.5f); d.sety(-0.5f);  d.setz(0.5f);	
                a.sety((a.gety() - (1.0f/sd*i)));	
                c.sety(a.gety()); 
                
            }
        }
    }
    
    
    void topbottom(points a,points b,points c,points d, int subdivisions){
        
    	int sd=subdivisions; 
    	
        if( subdivisions == 1){
            addTriangle(a.getx(),a.gety(),a.getz(),b.getx(),b.gety(),b.getz(),c.getx(),c.gety(),c.getz() );	
            addTriangle(c.getx(),c.gety(),c.getz(),b.getx(),b.gety(),b.getz(),d.getx(),d.gety(),d.getz());
            a.sety(-a.gety());b.sety(-b.gety());c.sety(-c.gety());d.sety(-d.gety());
            addTriangle(a.getx(),a.gety(),a.getz(),c.getx(),c.gety(),c.getz() ,b.getx(),b.gety(),b.getz());	
            addTriangle(c.getx(),c.gety(),c.getz(),d.getx(),d.gety(),d.getz(),b.getx(),b.gety(),b.getz());
    	}
    	else{
    		for(int i = 1; i <= sd; i++){
                float step= 1.0f/sd;
    			b.setz((a.getz())+step);						
    			for(int j = 1;j <= sd; j++){
    				c.setx((a.getx())+ step);				
    				addTriangle(a.getx(),a.gety(),a.getz(),b.getx(),b.gety(),b.getz(),c.getx(),c.gety(),c.getz() ); 
    				a.sety(-a.gety());b.sety(-b.gety()); c.sety(-c.gety());d.sety(-d.gety());
                   
                    addTriangle(a.getx(),a.gety(),a.getz(),c.getx(),c.gety(),c.getz() ,b.getx(),b.gety(),b.getz());
                    a.sety(-a.gety()); b.sety(-b.gety());c.sety(-c.gety());d.sety(-d.gety());d.setx(c.getx());d.setz(b.getz());
				
                   	addTriangle(c.getx(),c.gety(),c.getz(),b.getx(),b.gety(),b.getz(),d.getx(),d.gety(),d.getz()); 
                    a.sety(-a.gety());b.sety(-b.gety());c.sety(-c.gety()); d.sety(-d.gety());
                    
                    addTriangle(c.getx(),c.gety(),c.getz(),d.getx(),d.gety(),d.getz(),b.getx(),b.gety(),b.getz());
                    a.sety(-a.gety());b.sety(-b.gety());c.sety(-c.gety());d.sety(-d.gety());a.setx(c.getx()); a.sety(c.gety());
                    a.setz(c.getz()); b.setx(d.getx());b.sety(d.gety());b.setz(d.getz());
    			
    			}
    			
    			a.setx(-0.5f);  a.sety(0.5f);  a.setz(-0.5f);		
                b.setx(-0.5f); b.sety(0.5f);  b.setz(0.5f);	  
                c.setx(0.5f); c.sety(0.5f);  c.setz(-0.5f);	   
                d.setx(0.5f); d.sety(0.5f);  d.setz(0.5f);	   
    			a.setz((a.getz() + (1.0f/sd * i)));			
    			c.setz(a.getz());
    		}
    	}
    }
    
    void leftright(points a, points b, points c, points d, int subdivisions){
        
    	int sd=subdivisions; 
    	
        if( subdivisions == 1){
            addTriangle(a.getx(),a.gety(),a.getz(),b.getx(),b.gety(),b.getz(),c.getx(),c.gety(),c.getz() );	
            addTriangle(c.getx(),c.gety(),c.getz(),b.getx(),b.gety(),b.getz(),d.getx(),d.gety(),d.getz());
            a.setx(-a.getx());				
            b.setx(-b.getx());
            c.setx(-c.getx());
            d.setx(-d.getx());
            addTriangle(a.getx(),a.gety(),a.getz(),c.getx(),c.gety(),c.getz() ,b.getx(),b.gety(),b.getz());	
            addTriangle(c.getx(),c.gety(),c.getz(),d.getx(),d.gety(),d.getz(),b.getx(),b.gety(),b.getz());
    	}
    	else{
    		for(int i = 1; i <= sd; i++){
                float step= 1.0f/sd;
    			b.sety((a.gety())-step);						
    			for(int j = 1;j <= sd; j++){
    				c.setz((a.getz())+step);				
    				addTriangle(a.getx(),a.gety(),a.getz(),b.getx(),b.gety(),b.getz(),c.getx(),c.gety(),c.getz() );
                    a.setx(-a.getx());b.setx(-b.getx());c.setx(-c.getx());d.setx(-d.getx());
                   
                    addTriangle(a.getx(),a.gety(),a.getz(),c.getx(),c.gety(),c.getz() ,b.getx(),b.gety(),b.getz());
                    a.setx(-a.getx());b.setx(-b.getx());c.setx(-c.getx());d.setx(-d.getx());d.setz(c.getz());d.sety( b.gety());
    				
                    addTriangle(c.getx(),c.gety(),c.getz(),b.getx(),b.gety(),b.getz(),d.getx(),d.gety(),d.getz());
    				a.setx(-a.getx());b.setx(-b.getx());c.setx(-c.getx());d.setx(-d.getx());
                    
    				addTriangle(c.getx(),c.gety(),c.getz(),d.getx(),d.gety(),d.getz(),b.getx(),b.gety(),b.getz());
                    a.setx(-a.getx());b.setx(-b.getx());c.setx(-c.getx());d.setx(-d.getx());a.setx(c.getx()); 
                    a.sety(c.gety());a.setz(c.getz());b.setx(d.getx());b.sety(d.gety());b.setz(d.getz());
    			}
    			a.setx(-0.5f);  a.sety(0.5f);  a.setz(-0.5f);		
                b.setx(-0.5f); b.sety(-0.5f);  b.setz(-0.5f);	   
                c.setx(-0.5f); c.sety(0.5f);  c.setz(0.5f);	   
                d.setx(-0.5f); d.sety(-0.5f);  d.setz(0.5f);	   
                
    			a.sety((a.gety() - (1.0f/sd * i)));	
    			c.sety(a.gety());
    		}
    	}
    }
    
    
//
// makeCube - Create a unit cube, centered at the origin, with a given number
// of subdivisions in each direction on each face.
//
// @param subdivision - number of equal subdivisons to be made in each
//         direction along each face
//
// Can only use calls to addTriangle()
//
    public void makeCube (int subdivisions)
    {
    	if( subdivisions < 1 )
            subdivisions = 1;
    	
    	int sd=subdivisions; 
    	
    	points a = new points(-0.5f,0.5f,0.5f);
    	points b = new points(-0.5f,-0.5f,0.5f);
    	points c = new points(0.5f,0.5f,0.5f);
    	points d = new points(0.5f,-0.5f,0.5f);
        frontback(a,b,c,d,sd);	
        a.setx(-0.5f); a.sety(0.5f); a.setz(-0.5f);		
        b.setx(-0.5f); b.sety(0.5f); b.setz(0.5f);		
        c.setx(0.5f); c.sety(0.5f); c.setz(-0.5f);		
        d.setx(0.5f); d.sety(0.5f); d.setz(0.5f);		
        topbottom(a,b,c,d,sd);	
        a.setx(-0.5f); a.sety(0.5f); a.setz(-0.5f);		
        b.setx(-0.5f); b.sety(-0.5f); b.setz(-0.5f);			
        c.setx(-0.5f); c.sety(0.5f); c.setz(0.5f);		
        d.setx(-0.5f); d.sety(-0.5f); d.setz(0.5f);	
        leftright(a,b,c,d,sd);	
        return;        
    }
    
///
// makeCylinder - Create polygons for a cylinder with unit h, centered at
// the origin, with separate number of radial subdivisions and h
// subdivisions.
//
// @param radius - Radius of the base of the cylinder
// @param radialDivision - number of subdivisions on the radial base
// @param hDivisions - number of subdivisions along the h
//
// Can only use calls to addTriangle()
///
    
    public void makeCylinder (float radius, int radialDivisions, int heightDivisions)
    {
    	if( radialDivisions < 3 )
            radialDivisions = 3;

        if( heightDivisions < 1 )
            heightDivisions = 1;
       
    	float r=radius;
        int rd=radialDivisions;
		int hd=heightDivisions;
        
        float x0, x1, y0 = -0.5f, y1, z0, z1;
        	for (int i = 0; i < rd; i++) {
        		x0 = r * (float)Math.cos((float)i * 2 * Math.PI / (float)rd);
        		z0 = r * (float)Math.sin((float)i * 2 * Math.PI / (float)rd);
        		x1 = r * (float)Math.cos((float)(i+1) * 2 * Math.PI / (float)rd);
        		z1 = r * (float)Math.sin((float)(i+1) * 2 * Math.PI / (float)rd);

        		addTriangle(0.0f, -0.5f, 0.0f, x0, -0.5f, z0, x1, -0.5f, z1);
        		addTriangle(x1, 0.5f, z1, x0, 0.5f, z0, 0.0f, 0.5f, 0.0f);

        		for (int j = 0; j < hd; j++) {
        			y0 = (float)(j) / (float)hd - 0.5f;
        			y1 = (float)(j + 1) / (float)hd -0.5f;
        			addTriangle(x0, y1, z0, x1, y1, z1, x0, y0, z0);
        			addTriangle(x1, y1, z1, x1, y0, z1, x0, y0, z0);
        		}
        	}
    }
    
 ///
 // makeCone - Create polygons for a cone with unit h, centered at the
 // origin, with separate number of radial subdivisions and h
 // subdivisions
 //
 // @param radius - Radius of the base of the cone
 // @param radialDivision - number of subdivisions on the radial base
 // @param hDivisions - number of subdivisions along the h
 //
 // Can only use calls to addTriangle()
 ///
    public void makeCone (float radius, int radialDivisions, int heightDivisions)
    {
        if( radialDivisions < 3 )
            radialDivisions = 3;

        if( heightDivisions < 1 )
            heightDivisions = 1;
    	
    	int rd=radialDivisions;
		int hd=heightDivisions;
		float r = radius;
		float x1 = 0;
		float z1 = 0;
		float angle = 360.0f/ rd;
				
		for (int i = 1; i <= rd; i++) {
			float x = r * (float) (Math.cos((angle * (Math.PI / 180))));
			float z = r * (float) (Math.sin((angle * (Math.PI / 180))));
			z = -z;
			         
			if (i == 1){
				addTriangle(r, -0.5f, 0.0f, 0.0f, -0.5f, 0.0f, x, -0.5f, z);
				float xpre = r, ypre = -0.5f, zpre = 0.0f;
				float xnex = x, ynex = -0.5f, znex = z;
				float t = 1 / (float) hd;
				float h = 1;
				for (int j = 1; j <= hd; j++) {
					addTriangle(xnex * h, ynex, znex * h, xpre * (h - t), ypre + t, zpre * (h - t),xpre * h, ypre, zpre * h);
					addTriangle(xpre * (h - t), ypre + t, zpre* (h - t), xnex * h, ynex, znex * h,xnex * (h - t), ynex + t, znex * (h - t));
					h-= t;
					ynex=ynex + t;
					ypre=ypre + t;
				}
			}

			if (i != 1 && i < rd) {
				addTriangle(x1, -0.5f, z1, 0.0f, -0.5f, 0.0f, x, -0.5f, z);
				float xpre = x, ypre = -0.5f, zpre = z;
				float xnex = x1, ynex = -0.5f, znex = z1;
				float t = 1 / (float) hd;
				float h = 1;
				for (int j = 1; j <= hd; j++){
					addTriangle(xnex * h, ynex, znex * h, xpre * h, ypre, zpre * h, xpre* (h - t), ypre + t, zpre * (h - t));
					addTriangle(xpre * (h - t), ypre + t, zpre * (h - t), xnex * (h - t), ynex + t, znex* (h - t), xnex * h, ynex, znex * h);
					h-=t;
					ynex=ynex + t;
					ypre=ypre + t;
				}
			}
			if (i == rd){
				addTriangle(x1, -0.5f, z1, 0.0f, -0.5f, 0.0f, r, -0.5f, 0.0f);
				float xpre = x, ypre = -0.5f, zpre = z;
				float xnex = x1, ynex = -0.5f, znex = z1;
				float t = 1 / (float) hd;
				float h = 1;
				for (int j = 1; j <= hd; j++) {
					addTriangle(xnex * h, ynex, znex * h, xpre * h, ypre, zpre * h, xpre* (h - t), ypre + t, zpre * (h - t));
					addTriangle(xpre * (h - t), ypre + t, zpre * (h - t), xnex * (h - t), ynex + t, znex* (h - t), xnex * h, ynex, znex * h);
					h -= t;
					ynex = ynex + t;
					ypre = ypre + t;
				}
			}
			x1 = x;
			z1 = z;
			angle = angle + (360.0f / rd);
		}
    }
    
    
    
    void norm(points a) {
        float n = (float) (1.0f / Math.sqrt(a.getx() * a.getx() + a.gety() * a.gety() + a.getz() * a.getz()));
        a.setx(a.getx()*n); a.sety(a.gety()*n);a.setz(a.getz()*n);
        a.setx(a.getx()*0.5f); a.sety(a.gety()*0.5f); a.setz(a.getz()*0.5f);
        
    }
    
    class Triangle{
        points p1;
        points p2;
        points p3;
        
        Triangle(points x1, points x2, points x3) {
            p1 = x1;
            p2 = x2;
            p3 = x3;
        }
        
		public Triangle() {
			
		}
    };
    
    points midpoint(points a, points b){
        points c = new points();
        c.setx((a.getx() + b.getx())*0.5f);
        c.sety((a.gety() + b.gety())*0.5f);
        c.setz((a.getz() + b.getz())*0.5f);
        return c;
    }
    
    
 ///
 // makeSphere - Create sphere of a given radius, centered at the origin,
 // using spherical coordinates with separate number of thetha and
 // phi subdivisions.
 //
 // @param radius - Radius of the sphere
 // @param slides - number of subdivisions in the theta direction
 // @param stacks - Number of subdivisions in the phi direction.
 //
 // Can only use calls to addTriangle
 ///
    public void makeSphere(float radius, int slices, int stacks)
    {
    	if( slices < 3 ) slices = 3;
        if( stacks < 3 ) stacks = 3;
        
    	Vector<Triangle> tri = new Vector<Triangle>();
        Vector<Triangle> triangle1 = new Vector<Triangle>();
        
        float a = (float) (2.0f / ( 1.0f + Math.sqrt(5.0f)));
        points v0= new points( 0.0f,  a, -1.0f);
        points v1= new points(-a,  1.0f,  0.0f);
        points v2= new points( a,  1.0f,  0.0f);
        points v3= new points( 0.0f,  a,  1.0f);
        points v4= new points(-1.0f,  0.0f,  a);
        points v5= new points( 0.0f, -a,  1.0f);
        points v6= new points( 1.0f,  0.0f,  a);
        points v7= new points( 1.0f,  0.0f, -a);
        points v8= new points( 0.0f, -a, -1.0f);
        points v9= new points(-1.0f,  0.0f, -a);
        points v10= new points(-a, -1.0f, 0.0f);
        points v11= new points( a, -1.0f, 0.0f);
        
        norm(v0);norm(v1);norm(v2);norm(v3);norm(v4);norm(v5);norm(v6);norm(v7);norm(v8);norm(v9);norm(v10);norm(v11);
            
        Triangle t0=new Triangle(v0, v1, v2 );			
    	Triangle t1=new Triangle(v3, v2, v1 );			
    	Triangle t2=new Triangle(v3, v4, v5 );			
    	Triangle t3=new Triangle(v3, v5, v6 );
    	Triangle t4=new Triangle(v0, v7, v8 );
    	Triangle t5=new Triangle(v0, v8, v9);				
    	Triangle t6=new Triangle(v5, v10, v11 );
    	Triangle t7=new Triangle(v8, v11, v10 );
    	Triangle t8=new Triangle(v1, v9, v4 );
    	Triangle t9=new Triangle(v10, v4, v9 );
    	Triangle t10=new Triangle(v2, v6, v7 );				
    	Triangle t11=new Triangle(v11, v7, v6 );
    	Triangle t12=new Triangle(v3, v1, v4 );
    	Triangle t13=new Triangle(v3, v6, v2 );
    	Triangle t14=new Triangle(v0, v9, v1 );
    	Triangle t15=new Triangle(v0, v2, v7 );				
    	Triangle t16=new Triangle(v8, v10, v9 );
    	Triangle t17=new Triangle(v8, v7, v11 );
    	Triangle t18=new Triangle(v5, v4, v10 );
    	Triangle t19=new Triangle(v5, v11, v6 );
    	
    	
    	tri.addElement(t0);tri.addElement(t1);tri.addElement(t2);tri.addElement(t3);tri.addElement(t4);tri.addElement(t5);tri.addElement(t6);
    	tri.addElement(t7);tri.addElement(t8);tri.addElement(t9);tri.addElement(t10);tri.addElement(t11);
    	tri.addElement(t12);tri.addElement(t13);tri.addElement(t14);tri.addElement(t15);tri.addElement(t16);
    	tri.addElement(t17);tri.addElement(t18);tri.addElement(t19);
    	
        
    	for(int j=1; j <= slices; j++){
    		if(slices == 1){
    			for(int i=0;i<tri.size(); i++) {
    				addTriangle(tri.elementAt(i).p1.x,tri.elementAt(i).p1.y,tri.elementAt(i).p1.z,
                                tri.elementAt(i).p2.x,tri.elementAt(i).p2.y,tri.elementAt(i).p2.z,tri.elementAt(i).p3.x,
                                tri.elementAt(i).p3.y,tri.elementAt(i).p3.z);
                }}
    		else{
    			for(int i=0; i<tri.size(); i++){
    				points mp1p2 = midpoint(tri.elementAt(i).p1,tri.elementAt(i).p2);
    				points mp1p3 = midpoint(tri.elementAt(i).p1,tri.elementAt(i).p3);	
    				points mp2p3 = midpoint(tri.elementAt(i).p2,tri.elementAt(i).p3);
                    
    				Triangle T1=new Triangle(tri.elementAt(i).p1, mp1p2, mp1p3 );
    				triangle1.addElement(T1);
    				Triangle T2=new Triangle(mp1p2, tri.elementAt(i).p2, mp2p3 );
    				triangle1.addElement(T2);
    				Triangle T3=new Triangle(mp2p3, tri.elementAt(i).p3, mp1p3 );
    				triangle1.addElement(T3);
    				Triangle T4=new Triangle(mp1p2, mp2p3, mp1p3 );
    				triangle1.addElement(T4);
    			}
                
    			
    		}
    		
    		tri.clear();
    		for(int k=0;k<triangle1.size();k++)
    			tri.addElement(triangle1.elementAt(k));
            
    		for(int l=0;l<triangle1.size();l++)
    			triangle1.removeElementAt(l);
            
        }
    	for(int i=0;i<tri.size();i++){		
            norm(tri.elementAt(i).p1);
            norm(tri.elementAt(i).p2);
            norm(tri.elementAt(i).p3);
            addTriangle(tri.elementAt(i).p1.x,tri.elementAt(i).p1.y,tri.elementAt(i).p1.z,tri.elementAt(i).p2.x,tri.elementAt(i).p2.y,tri.elementAt(i).p2.z,tri.elementAt(i).p3.x,
                        tri.elementAt(i).p3.y,tri.elementAt(i).p3.z);
        }
        
    }
       
}