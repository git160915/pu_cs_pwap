import java.awt.Color;

public class KernelFilter {

    // Returns a new picture that applies the identity filter to the given picture.
    public static Picture identity(Picture picture) {
        int[][] iIdentityFilter = {{0, 0, 0},
                                   {0, 1, 0},
                                   {0, 0, 0}};
        float weight = 1;

        return applyKernelFilter(picture, iIdentityFilter, weight);
    }

    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture) {
        int[][] iGaussianBlurFilter = {{1, 2, 1},
                                       {2, 4, 2},
                                       {1, 2, 1}};
        float weight = (float) 1 / 16;

        return applyKernelFilter(picture, iGaussianBlurFilter, weight);
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        int[][] iSharpenFilter = {{0, -1, 0},
                                  {-1, 5, -1},
                                  {0, -1, 0}};
        float weight = 1;

        return applyKernelFilter(picture, iSharpenFilter, weight);
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        int[][] iLaplacianFilter = {{-1, -1, -1},
                                    {-1, 8, -1},
                                    {-1, -1, -1}};
        float weight = 1;

        return applyKernelFilter(picture, iLaplacianFilter, weight);
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        int[][] iEmbossFilter = {{-2, -1, 0},
                                 {-1, 1, 1},
                                 {0, 1, 2}};
        float weight = 1;

        return applyKernelFilter(picture, iEmbossFilter, weight);
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        int[][] iMotionBlurFilter = {{1, 0, 0, 0, 0, 0, 0, 0, 0},
                                     {0, 1, 0, 0, 0, 0, 0, 0, 0},
                                     {0, 0, 1, 0, 0, 0, 0, 0, 0},
                                     {0, 0, 0, 1, 0, 0, 0, 0, 0},
                                     {0, 0, 0, 0, 1, 0, 0, 0, 0},
                                     {0, 0, 0, 0, 0, 1, 0, 0, 0},
                                     {0, 0, 0, 0, 0, 0, 1, 0, 0},
                                     {0, 0, 0, 0, 0, 0, 0, 1, 0},
                                     {0, 0, 0, 0, 0, 0, 0, 0, 1}};
        float weight = (float) 1 / 9;

        return applyKernelFilter(picture, iMotionBlurFilter, weight); 
    }

    // Function that returns the value after applying the kernel to caculate the pixel in focus
    private static Picture applyKernelFilter(Picture picture, int[][] kernalFilter, float weight) {
        int iRed = 0, iGreen = 0, iBlue = 0;
        int iTmpRow = 0, iTmpCol = 0;
        int iHalfKernelSize = kernalFilter.length / 2;
        Color colorFiltered;
        Picture pictureFiltered = new Picture(picture.width(), picture.height());

        for (int iRow = 0; iRow < picture.height(); iRow++) {
            for (int iCol = 0; iCol < picture.width(); iCol++) {
                iRed = 0;
                iGreen = 0;
                iBlue = 0;

                for (int i = 0; i < kernalFilter.length; i++) {
                    for (int j = 0; j < kernalFilter[0].length; j++) {
                        iTmpRow = ((iRow - iHalfKernelSize + i) + picture.height()) % picture.height();
                        iTmpCol = ((iCol - iHalfKernelSize + j) + picture.width()) % picture.width();

                        // Get the color pixel at this row and column
                        colorFiltered = picture.get(iTmpCol, iTmpRow);

                        // Compute the kernel value for this pixel
                        iRed += colorFiltered.getRed() * kernalFilter[i][j];
                        iGreen += colorFiltered.getGreen() * kernalFilter[i][j];
                        iBlue += colorFiltered.getBlue() * kernalFilter[i][j];
                    }
                }

                iRed = Math.round(iRed * weight);
                iGreen = Math.round(iGreen * weight);
                iBlue = Math.round(iBlue * weight);

                if (iRed < 0) iRed = 0;
                if (iGreen < 0) iGreen = 0;
                if (iBlue < 0) iBlue = 0;

                if (iRed > 255) iRed = 255;
                if (iGreen > 255) iGreen = 255;
                if (iBlue > 255) iBlue = 255;

                pictureFiltered.set(iCol, iRow, new Color(iRed, iGreen, iBlue));
            }
        }

        return pictureFiltered;
    }

    public static void main(String[] args) {
        Picture picture = new Picture(args[0]);
        Picture pictureIdentityFiltered = identity(picture);
        Picture pictureGaussianBlurFiltered = gaussian(picture);
        Picture pictureSharpenFiltered = sharpen(picture);
        Picture pictureLaplacianFiltered = laplacian(picture);
        Picture pictureEmbossFiltered = emboss(picture);
        Picture pictureMotionBlurFiltered = motionBlur(picture);

        // picture.show();

        pictureIdentityFiltered.show();
        pictureGaussianBlurFiltered.show();
        pictureSharpenFiltered.show();
        pictureLaplacianFiltered.show();
        pictureEmbossFiltered.show();
        pictureMotionBlurFiltered.show();
    }
}