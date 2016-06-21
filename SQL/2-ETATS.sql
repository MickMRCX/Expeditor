USE [Expeditor]
GO

/****** Object:  Table [dbo].[Etat]    Script Date: 21/06/2016 14:01:30 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Etat](
	[Identifiant] [int] IDENTITY(1,1) NOT NULL,
	[Libelle] [ntext] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Identifiant] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Table des différents états des commandes' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Etat'
GO

